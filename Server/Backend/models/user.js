const mongoose=require('mongoose');
const uniqueValidator=require('mongoose-unique-validator');

const userSchema=mongoose.Schema({
  email:{type:String,required:true,unique:true},
  password:{type:String,required:true}
});
//Activate our 3rd party validator :
//Plugin ->another function that mongoose would run on the schema,
//that validates the data before saving it !
userSchema.plugin(uniqueValidator);

module.exports=mongoose.model('User',userSchema);
