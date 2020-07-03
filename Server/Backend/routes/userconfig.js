//IMPORTS:
const express = require('express');
const router = express.Router();
const UserConfig=require('../models/userconfig');
const checkAuth=require('../middlewares/check-auth');

//URL: /api/config


//Add config -> starts with false as configuredStatus
router.post('',checkAuth,(req,res)=>{
   const config=new UserConfig({
       creator:req.userData.userId,
       monthlyRevenue:0,
       wantedSaveValue:0,
       totalSaved:0,
       configStatus:false
   });
   config.save().then(savedConfig=>{
       res.status(201).json({_id:savedConfig._id});

   }).catch(err=>{
       res.status(500).json();
   })
})

router.get('',checkAuth,(req,res)=>{
    UserConfig.findOne({creator:req.userData.userId}).then(foundConfig=>{
        res.status(200).json({
            config:foundConfig
        });

    }).catch(err=>{
        res.status(500).json();
    })
})

router.put('',checkAuth,(req,res)=>{
   const config=new UserConfig({
    creator:req.userData.userId,
    monthlyRevenue:req.body.monthlyRevenue,
    wantedSaveValue:req.body.wantedSaveValue,
    totalSaved:req.body.totalSaved,
    configStatus:req.body.configStatus,
    _id:req.body._id
   })
   UserConfig.updateOne({_id:req.body._id},config).then(result=>{
       if(result.n>0){
           res.status(200).json();
       }else{
           res.status(401).json("Failed Authentication");
       }
   }).catch(err=>{
       res.status(500).json({message:"Unknown error!"});
   })
})

router.delete('/:id',checkAuth,(req,res)=>{
    UserConfig.deleteOne({_id:req.params.id}).then(result=>{
        if(result.n>0){
            res.status(200).json("Deleted Successfully");
        }else{
            res.status(401).json("Authentication failed!");
        }
    }).catch(err=>{
        res.status(500).json("Unknown Error Occured");
    })
})



module.exports=router;