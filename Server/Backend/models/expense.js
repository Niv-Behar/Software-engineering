const mongoose=require('mongoose');

const expenseSchema=mongoose.Schema({
  title:{type:String,required:true},
  amount:{type:Number,required:true},
  creator:{type:mongoose.Schema.Types.ObjectId,ref:"User",required:true},
  categoryId:{type:mongoose.Schema.Types.ObjectId,ref:"Category",required:true}

});

module.exports=mongoose.model('Expense',expenseSchema);
