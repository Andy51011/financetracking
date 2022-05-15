import React, { useState } from "react";
import SignIn from "./components/login/SignIn.jsx";
import 'bootstrap/dist/css/bootstrap.min.css';
import { AppContext } from "./context";
import LoginContainer from "./components/login/LoginContainer.jsx";
function App() {
  const [ register, setIsRegistered] = useState(false);
  const [ isLoggedIn, setIsLoggedIn ] = useState(false);
  return (
    <>
      <AppContext.Provider value={{register, setIsRegistered, isLoggedIn, setIsLoggedIn}}>
        <LoginContainer />
      </AppContext.Provider>
    </>
  );
}

export default App;
