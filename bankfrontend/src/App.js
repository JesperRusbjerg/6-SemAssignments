import React from 'react';
import logo from './logo.svg';
import './App.css';

class App  extends React.Component{
  constructor(props) {
    super(props);
    this.state = {acc1: '333', acc2:'3332', acc1Found: null, acc2Found: null};

  }

  handleChange = (event)  => {
    this.setState({[event.target.name]: event.target.value});
  }

   handleSubmit = async (event) =>{
    const response = await fetch(`http://localhost:8080/banking_0_9_war/banking/account/${this.state.acc1}`);
    const json = await response.json();
    const response2 = await fetch(`http://localhost:8080/banking_0_9_war/banking/account/${this.state.acc2}`);
    const json2 = await response2.json();
    console.log("hi")
    console.log(json2)

    this.setState({acc1Found: json, acc2Found: json2})

  }
  
  render(){
    console.log(this.state)

    return (
      <div>
    <form onSubmit={this.handleSubmit}>
    <label>
      Account 1:
      <input type="text" name="acc1" defaultValue={'333'} value={this.state.value} onChange={this.handleChange} />
    </label>
  </form>

  <form onSubmit={this.handleSubmit}>
    <label>
      Account 2:
      <input type="text" name="acc2"  defaultValue={'3332'} value={this.state.value} onChange={this.handleChange} />
    </label>
  </form>
  <input type="submit" value="Submit" onClick={this.handleSubmit}/>
   
  <DisplayAccounts
    acc1={this.state.acc1Found}
    acc2={this.state.acc2Found}
/>
    </div>

  );

}
}


function DisplayAccounts(props){
  if(props.acc1 == null || props.acc2 == null) return <div></div>

  return(
<div>
  <p>{props.acc1.balance}</p>
  <p>{props.acc2.balance}</p>
  </div>
  )

}

export default App;
