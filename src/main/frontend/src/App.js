import React, { useState } from "react";
import SignIn from "./components/login/SignIn.jsx";
import 'bootstrap/dist/css/bootstrap.min.css';
import { AppContext } from "./context";
import LoginContainer from "./components/login/LoginContainer.jsx";
import TopNavBar from "./components/navigation/TopNavBar.jsx";
function App() {
  const [ register, setIsRegistered] = useState(false);
  const [ isLoggedIn, setIsLoggedIn ] = useState(false);
  const [currUser, setCurrUser] = useState("");
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  return (
    <>
      <AppContext.Provider value={{register, setIsRegistered, isLoggedIn, setIsLoggedIn, currUser, setCurrUser, password, setPassword, username, setUsername}}>
        <TopNavBar />
        <LoginContainer />
      </AppContext.Provider>
    </>
  );
}

export default App;
