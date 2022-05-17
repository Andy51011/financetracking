import Navbar from "react-bootstrap/Navbar";
import Container from "react-bootstrap/Container";
import NavDropdown from "react-bootstrap/NavDropdown";
import "./TopNavBar.css";
const TopNavBar = () => {
  return (
    <>
      <div className="nav-container">
        <div className="nav-item ">
          <h3>Financial Tracker</h3>
        </div>
        <div className="nav-item">
          <Navbar.Text>Signed in as: Billy</Navbar.Text>
        </div>
      </div>
    </>
  )
}

export default TopNavBar;