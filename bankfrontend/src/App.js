import React from 'react';
import logo from './logo.svg';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Container, Col, Row } from 'react-bootstrap';

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = { acc1: '333', acc2: '3332', acc1Found: null, acc2Found: null, error: "" };

  }

  handleChange = (event) => {
    this.setState({ [event.target.name]: event.target.value });
  }

  handleSubmit = async (event) => {
    const response = await fetch(`http://localhost:8080/banking_0_9_war/banking/account/${this.state.acc1}`);
    const response2 = await fetch(`http://localhost:8080/banking_0_9_war/banking/account/${this.state.acc2}`);

    const json = await response.json();
    const json2 = await response2.json();
    if (json.hasOwnProperty('message')) {
      this.setState({ error: json.message })
    } else if (json2.hasOwnProperty('message')) {
      this.setState({ error: json2.message })
    }
    else {
      this.setState({ acc1Found: json, acc2Found: json2, error: "" })
    }

  }

  updateAccountsOnTransfer = (acc1, acc2) => {
    this.setState({ acc1Found: acc1, acc2Found: acc2 })
  }


  render() {


    return (
      <div>
        <Container>


          <Row >
            <Col xs={12}>
              <div className="centerElement">
                <h1 style={{ textAlign: "center" }}>Velkommen til den store bank!</h1><br></br>
              </div>
            </Col>
          </Row>
          <Row style={{ marginTop: "10px" }}>
            <Col xs={12}>
              <div className="centerElement">
                <h3 tyle={{ textAlign: "center" }}> Her kan du søge efter accounts, hvorefter du kan transfer penge imellem dem  </h3>
              </div>
            </Col>
          </Row>
          <Row style={{ marginTop: "50px" }}>
            <Col xs={12}>


              <div className="centerElement">
                <form >
                  <label>
                    Account Number:
      <input type="text" name="acc1" id="accFind" defaultValue={'333'} value={this.state.value} onChange={this.handleChange} />
                  </label>
                </form>

                <form onSubmit={this.handleSubmit} style={{ marginLeft: "50px" }}>
                  <label>
                    Account Number:
      <input type="text" name="acc2" defaultValue={'3332'} value={this.state.value} onChange={this.handleChange} />
                  </label>
                </form>
              </div>
            </Col>
          </Row>
          <Row >
            <Col xs={12}>
              <div className="centerElement">

                <input type="submit" value="Søg efter accounts" id="submitAcc" onClick={this.handleSubmit} />
              </div>
            </Col>
          </Row>

          <DisplayAccounts
            acc1={this.state.acc1Found}
            acc2={this.state.acc2Found}
            updateAccs={this.updateAccountsOnTransfer}
            msg={this.state.error}
          />


        </Container>
      </div>

    );

  }
}


class DisplayAccounts extends React.Component {
  constructor(props) {
    super(props);
    this.state = { acc1: '333', acc2: '3332', amount: 0, moneyTransfered: false, error: "" };
  }

  handleChange = (event) => {
    this.setState({ [event.target.name]: event.target.value });
  }

  handleSubmit = async (event) => {
    event.preventDefault();
    const response = await fetch(`http://localhost:8080/banking_0_9_war/banking/account/${this.state.acc1}/${this.state.acc2}/${this.state.amount}`);
    const json = await response.json();
    if (json.hasOwnProperty('message')) {
      console.log('xxxx')
      console.log(json.message)
      this.setState({ error: json.message })
    }else{
      this.props.updateAccs(json[0], json[1])
      this.setState({ moneyTransfered: true })
    }
  }

  render() {

    console.log(this.state)

    if (this.props.msg != "") {
      return (
      <div className="centerElement"><Error
        msg={this.props.msg}
      /></div>
      )
    }


    if (this.props.acc1 == null || this.props.acc2 == null) return <div></div>

    return (
      <div id="accDisplayed">
        <Row style={{ marginTop: "20px" }}>
          <Col xs={2}>

          </Col>
          <Col xs={4}>
            <div style={{ backgroundColor: "lightGreen", borderRadius: "20px" }}>
              <h4 style={{ textAlign: "center" }}>Account number: {this.props.acc1.number}</h4>
              <h5 style={{ textAlign: "center" }}>Account balance: {this.props.acc1.balance}</h5>
              <br></br>
              <h5 style={{ textAlign: "center" }}>Bank: {this.props.acc1.bank.name}</h5>
            </div>
          </Col>
          <Col xs={4}>
            <div style={{ backgroundColor: "lightGrey", borderRadius: "20px" }}>
              <h4 style={{ textAlign: "center" }}>Account number: {this.props.acc2.number}</h4>
              <h5 style={{ textAlign: "center" }}>Account balance: {this.props.acc2.balance}</h5>
              <br></br>
              <h5 style={{ textAlign: "center" }}>Bank: {this.props.acc2.bank.name}</h5>
            </div>
          </Col><Col xs={2}>

          </Col>
        </Row>

        <Row style={{ marginTop: "25px" }}>
          <Col xs={12} style={{ backgroundColor: "#FF7F50" }}>


            <h5 style={{ textAlign: "center" }}> Transfer money</h5>
            <div className="centerElement" >
              <form >
                From:
      <input type="text" name="acc1" defaultValue={'333'} value={this.state.value} onChange={this.handleChange} />
      To:
      <input type="text" name="acc2" defaultValue={'3332'} value={this.state.value} onChange={this.handleChange} /><br></br>
                <div className="centerElement" style={{ marginTop: "10px" }}>

                  Amount
      <input type="number" name="amount" value={this.state.value} id="moneys" onChange={this.handleChange} />
                </div>

                <div className="centerElement" style={{ marginTop: "10px" }}>
                  <input type="submit" value="Søg efter accounts" id="tranferMoney" onClick={this.handleSubmit} />
                </div>


                <div className="centerElement" style={{ marginTop: "10px" }}>
                  <MoneyTransfered
                    transfered={this.state.moneyTransfered}
                    error={this.state.error}
                  />
                </div>
              </form>

            </div>
          </Col>


        </Row>

      </div>

    )
  }
}

function MoneyTransfered(props) {
  if(props.error != "") {
    return(
      <Error
      msg={props.error}
      />

  )}
  if (!props.transfered) return <div></div>


  return (
    <h5 id="moneyTransfered"> transfered successfully!!</h5>
  )

}

function Error(props) {
  console.log(props)
  if (props.msg == "" ) return <div></div>

  return (
    <div id="ERROR"><h5>{props.msg}</h5></div>
  )

}

export default App;
