const mongoose=require('mongoose');

const categorySchema=mongoose.Schema({
  title:{type:String,required:true},
  amount:{type:Number,required:true},
  amountUsed:{type:Number,required:true},
  creator:{type:mongoose.Schema.Types.ObjectId,ref:"User",required:true}

});

module.exports=mongoose.model('Category',categorySchema);
