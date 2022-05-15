import React, { useContext } from "react";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import { AppContext } from "../../context.js";

const SignIn = () => {
  const { register, setIsRegistered } = useContext(AppContext);

  const displayRegisterPage = () => {
    setIsRegistered(true);
  }


  return (
    <>
      <Form>
        <Form.Group className="mb-3" controlId="formBasicEmail">
          <Form.Label>Username</Form.Label>
          <Form.Control type="email" placeholder="Enter email" />
        </Form.Group>
        <Form.Group className="mb-3" controlId="formBasicPassword">
          <Form.Label>Password</Form.Label>
          <Form.Control type="password" placeholder="Password" />
        </Form.Group>
        <Form.Group>
        <Button variant="primary" type="submit">
          Sign In
        </Button>
        <Form.Text id="register"> or <span className="create-account" onClick={displayRegisterPage}>Create an Account</span></Form.Text>
        </Form.Group>
       </Form>
    </>
  )
}

export default SignIn;