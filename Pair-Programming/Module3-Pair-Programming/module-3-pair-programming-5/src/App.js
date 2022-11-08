import logo from './logo.svg';
import './App.css';
import Main from './component/MainComponent'
import { useEffect, useState } from 'react';
import {Form,Button,Card, CardImg, CardText, CardBody,
  CardTitle} from  'reactstrap';
//import {GetCards} from'./component/GetCards';

function App() {
  const post=<Main/>
  // return (
  //   <div className="App">
  
  //     <div>
  //       <Main/>
        
  //     </div>
  //   </div>
  // );
  // }


  const [newCard,setnewCard]= useState({});
  useEffect(()=>{
    let mounted = true;

    getCard().then(data=>{
      if(mounted){
        setnewCard(data)
      }
    })

    return()=> mounted=false;
  },[]);


async function getCard(){
  return fetch ('http://localhost:8080/api/cards/random')
            .then(response=> response.json())
}

const handleGetNextCard =(event)=>{
  window.location.reload(false);
  
}
let toggle=false;
const [userCollections,setuserCollections]= useState({});


function handleChange(e) {
  //alert(e.target.value);
  setnewCard({...newCard, caption: e.target.value});
  //alert(JSON.stringify(newCard));
}

function handleSetUserCollections(e){
  alert("handle");

  fetch("http://localhost:8080/api/cards", {
    method: "POST",
    cache: "no-cache",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(newCard),
  })
    .then((response) => {
      if (response.ok) {
        alert("Saved");
      }
    })
    .catch((err) => {
      console.error("from POST " + err);
      alert("Could not save card!");
    });
}

return(
  <div className='App'>
      <div id="card">
        <Card id="cat-card">
          <CardTitle id="cat-fact">
              <h3>{newCard.catFact} </h3> 
          </CardTitle>
          <CardImg top src={newCard.imgUrl} alt="cat" id="cat_pic" />
        </Card>
      </div>
      
      {/* <Form> */}
      <input
        onChange={handleChange}
        type="text"
        placeholder="Caption me!"
        id="caption_box"
      />
      <br/>
      <br/>

         <Button value={newCard.catFact} type="button" color="primary" onClick={handleSetUserCollections}>Add to collection</Button>                     
         <Button type="button" value="submit" color="primary" onClick={handleGetNextCard}>Get next card</Button>                      
      {/* </Form> */}
     {/* {toggle && <img 
      src={userCollections.imgUrl}
      alt="new"
      />
     } */}
     <div><Main/></div>
     
    </div>
      
);
}


export default App;

