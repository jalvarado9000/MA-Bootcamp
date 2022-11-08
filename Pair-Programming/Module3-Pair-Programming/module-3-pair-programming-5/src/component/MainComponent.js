import React, { useState, useEffect } from 'react';
import {Form,Button,Card, CardImg, CardText, CardBody,
   CardTitle} from  'reactstrap'
const App = () => {
   const [posts, setPosts] = useState([]);
   const[toggle,setToggle] = useState(false)
   useEffect(() => {
      fetch('http://localhost:8080/api/cards')
         .then((response) => response.json())
         .then((data) => {
            console.log(data);
            setPosts(data);
         })
         .catch((err) => {
            console.log(err.message);
         });
   }, []);

   function handleDelete(e){
         
         fetch("http://localhost:8080/api/cards/"+ e.target.value,{
         method: "DELETE",
         cache: "no-cache",
         headers: {
            "Content-Type": "application/json",
         },
         
      })
         .then((response) => {
            if (response.ok) {
            alert("delete");
            }
         })
         .catch((err) => {
            console.error("from delete " + err);
            alert("Could not delete card!");
         });
   }

   function handleEdit(){     
      alert(JSON.stringify(newCard))

      fetch("http://localhost:8080/api/cards/"+newCard.catCardId, {
      method: "PUT",
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

   function updateCaption(e,post){
      //alert("update");
      setnewCard( {...post, caption: e.target.value});
   }
   const [newCard,setnewCard]= useState({});
   
   


   
   return (
      <div className="posts-container">
         {posts.map((post) => { 
            //let card=JSON.stringify(post);//alert(card)
            return (
               <div id="card">
               <Card id="cat-card">
                 <CardTitle id="cat-fact">
                     <h3>{post.catFact} </h3> 
                 </CardTitle>
                <CardImg top src={post.imgUrl} alt="cat" id="cat_pic" />
              </Card>
              <Button type="button" value={post.catCardId} onClick={handleDelete} color="primary" >Delete</Button>                      
              <Button className="button add" type="button" onClick={handleEdit}>Add caption</Button>
             <input
                        onChange={event => updateCaption(event, post) }
                        type="text"
                        placeholder="Caption me!"
                        id="caption_box" />
                 
              
       </div>
            );
         })}
      </div>
      );
   };
   
   export default App;