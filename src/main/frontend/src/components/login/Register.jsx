import React, { useState, useContext } from "react";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import userRegistrationUrl from "../api/userRegistration";
import { AppContext } from "../../context.js";
const axios = require('axios').default;

const Register = () => {
  const {setIsRegistered } = useContext(AppContext);

  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [username, setUserName] = useState("");
  const [password, setPassword] = useState("");
  const [registrationSuccess, setRegistrationSuccess] = ("");

  const handleFirstName = (e) => {
    setFirstName(e.target.value);
  }

  const handleLastName = (e) => {
    setLastName(e.target.value);
  }

  const handleEmail = (e) => {
    setEmail(e.target.value);
  }

  const handleUsername = (e) => {
    setUserName(e.target.value);
  }

  const handlePassword= (e) => {
    setPassword(e.target.value);
  }

  const cancelRegisterPage = () => {
    setIsRegistered(false);
  }

  // send to server as post when user registers
  const signUp = (e) => {
    e.preventDefault();
    axios.post(userRegistrationUrl, {
      firstName: firstName,
      lastName: lastName,
      username: username,
      password: password,
      email: email
    }).then(function (response) {
      // load screen?
    })
    .catch(function(error) {
    // display error
    });
  }

  return (
    <>
    <Form onSubmit={signUp}>
    <Form.Group className="mb-3" controlId="formBasicEmail">
      <Form.Label>First name</Form.Label>
      <Form.Control type="text" placeholder="Enter your first name" value={firstName} onChange={handleFirstName} />
    </Form.Group>
    <Form.Group className="mb-3" controlId="formBasicEmail">
      <Form.Label>Last name</Form.Label>
      <Form.Control type="text" placeholder="Enter last name" value={lastName} onChange={handleLastName}/>
    </Form.Group>
    <Form.Group className="mb-3" controlId="formBasicEmail">
      <Form.Label>Email</Form.Label>
      <Form.Control type="email" placeholder="Enter email" value={email} onChange={handleEmail}/>
    </Form.Group>
    <Form.Group className="mb-3" controlId="formBasicEmail">
      <Form.Label>Username</Form.Label>
      <Form.Control type="text" placeholder="Enter username" value={username} onChange={handleUsername} />
    </Form.Group>
    <Form.Group className="mb-3" controlId="formBasicPassword">
      <Form.Label>Password</Form.Label>
      <Form.Control type="password" placeholder="Password" value={password} onChange={handlePassword}/>
    </Form.Group>
    <Form.Group>
    <Button variant="primary" type="submit">
      Register
    </Button>
    <Form.Text id="cancel-form"> or <span className="cancel-form" onClick={cancelRegisterPage}>Cancel</span></Form.Text>
    </Form.Group>
   </Form>
    </>
  )
}

export default Register;