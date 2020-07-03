//IMPORTS:
const express = require('express');
const router = express.Router();
const bcrypt = require('bcryptjs');
const jwt = require('jsonwebtoken');
const User = require('../models/user');

//Signup route: /api/user/signup
router.post("/signup", (req, res, next) => {
  bcrypt.hash(req.body.password, 10).then(hash => {
    const user = new User({
      email: req.body.email,
      password: hash
    });
    user.save().then(userDocument => {
      res.status(201).json({
        message: 'User created successfully',
        userData: userDocument
      });
    }).catch(err => {
      res.status(500).json({
        message: 'Email already exists!'
      });
    });
  })
});


//Login route : /api/user/login
router.post("/login", (req, res, next) => {

  User.findOne({email:req.body.email})
  .then(user=>{
      if(!user){
        return res.status(401).json({message:'Wrong Email'});
      }
      const result=bcrypt.compareSync(req.body.password,user.password);
      if(!result){
        return res.status(401).json({message:'Wrong password'});
      }
      const token=jwt.sign({email:user.email,userId:user._id},process.env.JWT_KEY);
      res.status(200).json({token:token,userId:user._id});
  }).catch(err=>{
    return res.status(404).json({message:'Unexpected error'});
  });
});




module.exports = router;
