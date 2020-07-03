//IMPORTS:
const express = require('express');
const router = express.Router();
const Category=require('../models/categories');

const checkAuth=require('../middlewares/check-auth');

"api/category"
router.post("",checkAuth,(req,res,next)=>{
   const category=new Category({
       title:req.body.title,
       amount:req.body.amount,
       amountUsed:req.body.amountUsed,
       creator:req.userData.userId
   });
   category.save().then(
       createdCategory=>{
             res.status(201).json({
                 message:"Category created succesfully",
                 category:createdCategory
            })
       }
   ).catch(err=>{
        res.status(500).json({message:"Category creation failed!"});
   })
});

router.get("",checkAuth,(req,res,next)=>{
    Category.find({creator:req.userData.userId}).then(
        documents=>{
            res.status(200).json({
                categories:documents
            });
        }
    ).catch(err=>{
        res.status(500).json({message:"Fetching categories failed!"});
    })
})

router.put("",checkAuth,(req,res,next)=>{
    console.log("success 1");
    const category=new Category({
        title:req.body.title,
        amount:req.body.amount,
        amountUsed:req.body.amountUsed,
        creator:req.body.creator,
        _id:req.body._id
    });
    console.log("success 2");
    Category.updateOne({creator:req.body.creator,_id:req.body._id},category).then(
        result=>{
            if(result.n>0){
                res.status(200).json({message:"Updated succesfully"});
            }
            else{
                res.status(401).json({message:"authentication failed"});
            }
        }
    ).catch(()=>{
        res.status(500).json({message:"couldn't update category"});
    })
})

router.delete("/:_id",checkAuth,(req,res,next)=>{
   Category.deleteOne({creator:req.userData.userId,_id:req.params._id})
   .then(result=>{
       if(result.n>0){
           res.status(200).json({message:"Deleted succesfully"});
       }
       else{
           res.status(401).json({message:"authentication failed!"});
       }
   }).catch(()=>{
       res.status(500).json({message:"couldn't delete category"});
   })
});

router.delete("",checkAuth,(req,res)=>{
    Category.deleteMany({creator:req.userData.userId}).then(result=>{
        res.status(200).json({});

    }).catch(err=>{
        res.status(500).json();
    })
})



module.exports=router;
