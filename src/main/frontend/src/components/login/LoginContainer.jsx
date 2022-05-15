import React, { useContext } from "react";
import { AppContext } from "../../context.js";
import SignIn from "./SignIn"
import Register from "./Register";

const LoginContainer = () => {
  const { register } = useContext(AppContext);
  return (
    <>
      <div className="form-container">
        {register ? <Register /> : <SignIn/>}
      </div>
    </>
  )
}

export default LoginContainer;