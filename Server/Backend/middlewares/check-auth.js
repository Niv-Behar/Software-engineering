const jwt=require('jsonwebtoken');

module.exports=(req,res,next)=>{
  try{
    //Expect a "Bearer afasafsafaga" token , throws error upon failure of finding this header !
    const token=req.headers.authorization.split(" ")[1];
    //Throws an error upon failure:
    const decodedToken=jwt.verify(token,process.env.JWT_KEY);

    //Before moving on -> attach the decodedTokenData to the ongoing request:
    req.userData={email:decodedToken.email,userId:decodedToken.userId};
    //Passed the verification , let the request continue to the next middleware !
    next();

  }
  catch{
     res.status(401).json({message:'Auth failed'});
  }
}
