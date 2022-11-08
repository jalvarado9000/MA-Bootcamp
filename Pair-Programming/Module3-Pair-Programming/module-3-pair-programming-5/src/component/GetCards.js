import {Form,Button,Card, CardImg, CardText, CardBody,
    CardTitle} from  'reactstrap'
import { useEffect, useState } from 'react';


export function GetCards(){

    const [allCards,setAllCards]= useState([]);
    useEffect(()=>{
    let mounted = true;

    getCard().then(data=>{
      if(mounted){
        setAllCards(data);
        alert(allCards)
      }
    })

    return()=> mounted=false;
  },[]);


async function getCard(){
  return fetch ('http://localhost:8080/api/cards')
            .then(response=>{
                if(response.ok){
                    alert("get")
                }
            })
            .then(response=> response.json())
}

// allCards.map((newCards)=>{

// })
return (<div></div>
        // <div className="posts-container">
        //    {allCards.map((card) => {
        //       return (
        //          <div className="post-card" key="card">
        //             <h2 className="post-title">{card.catFact}</h2>
        //          </div>
        //         )})
        //     }
        //       </div>
)
// return(
//     <div className="all-card-collections">
//         {allCards.map((newCard) => {
//            <div id="card">
//            <Card id="cat-card">
//              <CardTitle id="cat-fact">
//                  <h3>{newCard.catFact} </h3> 
//              </CardTitle>
//              <CardImg top src={newCard.imgUrl} alt="cat" id="cat_pic" />
//            </Card>
//          </div>
//         })
//     }
//     </div>

// );
}