import React, { useState } from "react";
import SignIn from "./components/login/SignIn.jsx";
import 'bootstrap/dist/css/bootstrap.min.css';
import { AppContext } from "./context";
import LoginContainer from "./components/login/LoginContainer.jsx";
import TopNavBar from "./components/navigation/TopNavBar.jsx";
function App() {
  const [ register, setIsRegistered] = useState(false);
  const [ isLoggedIn, setIsLoggedIn ] = useState(false);
  return (
    <>
      <AppContext.Provider value={{register, setIsRegistered, isLoggedIn, setIsLoggedIn}}>
        <TopNavBar />
        <LoginContainer />
      </AppContext.Provider>
    </>
  );
}

export default App;
