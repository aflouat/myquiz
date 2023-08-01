const portNumber = 18083;
const url = 'http://localhost:' + portNumber;
const username = document.getElementById('username');
const saveScoreBtn = document.getElementById('saveScoreBtn');
const finalScore = document.getElementById('finalScore');
const mostRecentScore = localStorage.getItem('mostRecentScore');

const highScores = JSON.parse(localStorage.getItem('highScores')) || [];

const MAX_HIGH_SCORES = 5;

finalScore.innerText = mostRecentScore;

username.addEventListener('keyup', () => {
    saveScoreBtn.disabled = !username.value;
});

saveHighScore = (e) => {
    e.preventDefault();
    //get the quiz title from the local storage
const quizTitle = localStorage.getItem('quizTitle');
//get the quiz number from the local storage
const quizNumber = localStorage.getItem('quizNumber');

 

    const d = new Date();
    const dateTime = d.toISOString(); // Use ISO 8601 format for the date and time

    const score = {
        quizId: quizNumber, // Replace with the actual quiz ID
        quizTitle: quizTitle,
        playerId: null, // Replace with the actual player ID
        playerNickname: username.value,
        score: mostRecentScore,
        date: dateTime
    };
console.log('JSON Game:', JSON.stringify(score));

    fetch(url +'/games', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(score)
    }).then(response => response.json())
        .then(savedScore => {
            console.log('Success:', savedScore);

            // Redirect to the highscores page or any other relevant action
            window.location.assign('./highscores.html');
        })
        .catch(error => {
            console.error('Error:', error);
        });
};



//display questions already asked, selected answers and correct answers in the div quiz_feedback_table already created in the end.html file
const quizFeedbackTable = document.getElementById('quiz_feedback_table');
// get quizFeedbackTable child called tbody
const tableBody = quizFeedbackTable.getElementsByTagName('tbody')[0];
//create a function to initialize all variables
const init = () => {
    
    let tableRow;
    //create a table cell
    let tableCell ;
    //create a table cell text with questionsAlreadyAsked array
    let tableCellText;
    let questionText;
    let correctAnswerNumber;
    let correctAnswerText;
    let selectedAnswerNumber;
    let selectedAnswerText;
    let tableCellSelectedAnswer;
    let tableCellCorrectAnswer;
    let tableCellCorrectAnswerText;
    let tableCellSelectedAnswerText;

    
};
//get the questions already asked from the local storage
let questions = JSON.parse(localStorage.getItem('questions'));
//get the selected answers from the local storage
let selectedAnswers = JSON.parse(localStorage.getItem('selectedAnswers'));
//create a table row with a loop on questions array
for (let i = 0; i < questions.length; i++) {
    //get the question text from the questions array
    questionText = questions[i].question;
    //get the correct answer number from the questions array
    correctAnswerNumber = questions[i]['correctAnswer'];
    //get the correct answer text from the questions array  questions[0]['choices'][2] 
    correctAnswerText = questions[i]['choices'][correctAnswerNumber ]['text'];
    // get the selected answer number from the questions array
    selectedAnswerNumber = selectedAnswers[i];
    //get the selected answer text from the questions array
    selectedAnswerText = questions[i]['choices'][selectedAnswerNumber]['text'];
    //create a table row
    tableRow = document.createElement('tr');
    //create a table cell
    tableCell = document.createElement('td');
    //create a table cell text with questionsAlreadyAsked array
    tableCellText = document.createTextNode(questionText);
       //append the text to the cell
       tableCell.appendChild(tableCellText);
       //append the cell to the row
       tableRow.appendChild(tableCell);
    //create a table cell for selected answers
    tableCellSelectedAnswer = document.createElement('td');
    //create a table cell text with selectedAnswers array
    tableCellSelectedAnswerText = document.createTextNode(selectedAnswerText);
    //add a class to the cell to color it in red if the answer is incorrect
    if (selectedAnswerNumber != correctAnswerNumber) {
        tableCellSelectedAnswer.classList.add('incorrect');
    }else{
        tableCellSelectedAnswer.classList.add('correct');
    }
    //append the text to the cell
    tableCellSelectedAnswer.appendChild(tableCellSelectedAnswerText);
          //append the cell to the row
    tableRow.appendChild(tableCellSelectedAnswer);

    //create a table cell for correct answers
    tableCellCorrectAnswer = document.createElement('td');
    //create a table cell text with correctAnswers array
    tableCellCorrectAnswerText = document.createTextNode(correctAnswerText);
    //append the text to the cell
    tableCellCorrectAnswer.appendChild(tableCellCorrectAnswerText);
    //append the cell to the row
    tableRow.appendChild(tableCellCorrectAnswer);
    
    //append the row to the body
    tableBody.appendChild(tableRow);


}
//add tablebody to the table
quizFeedbackTable.appendChild(tableBody);

