import Navbar from "react-bootstrap/Navbar";
import Container from "react-bootstrap/Container";
import NavDropdown from "react-bootstrap/NavDropdown";
import "./TopNavBar.css";
const TopNavBar = () => {
  return (
    <>
    <Navbar>
  <Container className="container">
    <Navbar.Brand href="#home">Financial Tracker</Navbar.Brand>
    <Navbar.Toggle />
    <Navbar.Collapse className="justify-content-end">
      <span>Signed in as:</span>
    <NavDropdown title="Mark Otto">
        <NavDropdown.Item href="#action/3.1">Action</NavDropdown.Item>
        <NavDropdown.Item href="#action/3.2">Another action</NavDropdown.Item>
        <NavDropdown.Item href="#action/3.3">Something</NavDropdown.Item>
      </NavDropdown>
    </Navbar.Collapse>
  </Container>
</Navbar>
    </>
  )
}

export default TopNavBar;