const mongoose=require('mongoose');

const userConfigSchema=mongoose.Schema({
  creator:{type:mongoose.Schema.Types.ObjectId,ref:"User",required:true},
  monthlyRevenue:{type:Number,required:true,min:0},
  wantedSaveValue:{type:Number,required:true,min:0},
  totalSaved:{type:Number,required:true},
  configStatus:{type:Boolean,required:true}

});

module.exports=mongoose.model('Config',userConfigSchema);
