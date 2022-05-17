import React, { useContext } from "react";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import { AppContext } from "../../context.js";
import listOfUsers from "../api/listOfUsers";
import axios from "axios";

const SignIn = () => {
  const { register, setIsRegistered, currUser, setCurrUser, username, setUsername, password, setPassword} = useContext(AppContext);

  const displayRegisterPage = () => {
    setIsRegistered(true);
  }

  const handleUsername = (e) => {
    setUsername(e.target.value)
  }

  const handlePassword = (e) => {
    setPassword(e.target.value);
  }

  const loginSubmit = (username, password) => {
    axios.get(listOfUsers)
      .then(function (response) {
        console.log(response)
      })
      .catch(function (error) {

      })
  }


  return (
    <>
      <Form onSubmit={loginSubmit}>
        <Form.Group className="mb-3" controlId="formBasicEmail">
          <Form.Label>Username</Form.Label>
          <Form.Control type="email" placeholder="Enter email" onChange={handleUsername} value={username}/>
        </Form.Group>
        <Form.Group className="mb-3" controlId="formBasicPassword">
          <Form.Label>Password</Form.Label>
          <Form.Control type="password" placeholder="Password" onChange={handlePassword} value={password} />
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