//IMPORTS:
const express = require('express');//Importing
const bodyParser = require('body-parser');//Importing body-parser package - parses body data of different type
const mongoose=require('mongoose');

//ROUTES:
const userRoutes=require('./routes/user');
const categoryRoutes=require('./routes/category');
const expenseRoutes=require('./routes/expense');
const userConfigRoutes=require('./routes/userconfig');


mongoose.connect(//"mongodb+srv://yoniveksler:x78PoNGrYWjFOTgI@cluster0-d1ha1.mongodb.net/Timely"
"mongodb+srv://yoniveksler:"+process.env.MONGO_ATLAS_PW+"@cluster0-l55jq.mongodb.net/Project"
,{useNewUrlParser:true,useUnifiedTopology:true})
.then(()=>{
  console.log('Connected to DB!');
}).catch(()=>{
  console.log('Connection failed!');
});
mongoose.set('useCreateIndex', true);//Stops userCreateIndex warning!
//TODO : Mongo credentials:
//yoniveksler
//NT7EPDXNnkx1hxH5

const app = express();//Creating an express app

//Using body parser.json to parse the request body
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));

//SETTING CORS:
app.use((req, res, next) => {
  res.setHeader("Access-Control-Allow-Origin", "*");
  res.setHeader("Access-Control-Allow-Headers", "Origin,X-Required-With,Content-Type,Accept,Authorization");
  res.setHeader("Access-Control-Allow-Methods", "GET,POST,PATCH,PUT,DELETE,OPTIONS");
  //Passing our middleware to the next middleware , because we dont send the response!
  next();
});


//ROUTES:
app.use('/api/user', userRoutes);//Using the middlewares targeting users!
app.use('/api/category',categoryRoutes);//Using the middlewares targeting events!
app.use('/api/expense',expenseRoutes);
app.use('/api/config',userConfigRoutes);


//EXPORT THE APP:
module.exports=app;
