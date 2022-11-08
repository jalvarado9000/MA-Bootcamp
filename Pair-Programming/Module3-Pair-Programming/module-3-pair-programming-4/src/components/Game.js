import { useState } from "react";

const Game = () => {

  const [rightOp, setRightOp] = useState(getRandomNumber(10));
  const [leftOp, setLeftOp] = useState(getRandomNumber(10));
  const [correctAnswer, setCorrectAnswer] = useState(rightOp * leftOp);
  const [score, setScore] = useState(0);
  const [problem, setProblem] = useState(1);
  const [hide, setHide] = useState(false);

  function getRandomNumber(max){
    return Math.floor(Math.random() * Math.floor(max));
  }

  function shuffleArray(arr) {
    return arr.sort(function (a, b) { return Math.random() - 0.5 })
  }
 
  function updateProblem() {
    let newLeftOp = getRandomNumber(10);
    let newRightOp = getRandomNumber(10);
    setLeftOp(newLeftOp);
    setRightOp(newRightOp);
    setCorrectAnswer(newLeftOp * newRightOp);
  }

  function RenderListItems(props){
    const answers = props.answers.map((answer)=>{
        return(
            <>
            {!props.hide && (
            <li className="expression show-hide" onClick={(e)=>{
                setProblem(problem+1);
                updateProblem();
                if(problem<=10){
                    let currentAns = parseInt(e.target.innerText);
                    if(currentAns===correctAnswer){
                        setScore(score+1); 
                    }
                }
                if(problem===10){
                    setProblem(10)
                    setHide(!hide);
                }            
            }}
                > 
            {answer} 
              </li>
              )}
            </>
          );
        });
        return (
          <>
            <div class="a" id="answers" className="show-hide">
              <ul>{answers}</ul>
            </div>
          </>
        );
      }

      function RenderProblem(props) {
        return (
          <>

            {!props.hide && problem<11 && (
                <div className="expression show-hide">
            {props.leftOp}  * {props.rightOp}
            </div>
            )}

            </>
        );
      }

      function RenderStatement(props) {
        return (
          <div className="expression show-hide">
            {!props.hide && problem<11 && (
            <>
            <p className="show-hide">Please select an answer below the problem by clicking on the box</p>
            </>
            )}
            </div>
        );
      }

      function RenderScore(props){
        return (
           (
          <p>
            Problem: <span className="currentProblem">{props.problem}</span>/10
            | Score: <span className="currentScore">{props.score}</span>
          </p>
          )
        );
      }

    function resetGame(){
        setScore(0);
        setProblem(1);
        updateProblem();
        setHide(!hide)  
    }

    return ( 
        <>
      <body>
    <header>
    <h1>Math Practice</h1>
    <RenderStatement hide={hide}/>
  </header>
  <main >

    <section id="problem">  

       <RenderProblem leftOp={leftOp} rightOp={rightOp} hide={hide} problem={problem}/>

       </section>

      <RenderScore problem={problem} score={score}/>
      
      <RenderListItems
            problem={problem}
          correctAnswer={correctAnswer}
          hide={hide}
          answers={shuffleArray([
            getRandomNumber(82),
            getRandomNumber(82),
            getRandomNumber(82),
            correctAnswer
          ])}
        />
    
    <button id="btnStartOver" className="show-hide" onClick={resetGame}>
        Start Over</button>

  </main>
  <footer>
    Copyright &copy; 2020 LearnIT. All Rights Reserved.
  </footer>
  <script src="js/app.js"></script>
  </body>
  </>
    );
}
 
export default Game;