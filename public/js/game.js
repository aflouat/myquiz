// game.js 
//const portNumber = 8081;
//let url = 'http://localhost:' + portNumber;
const question = document.getElementById('question');
const choices = Array.from(document.getElementsByClassName('choice-text'));
const progressText = document.getElementById('progressText');
const scoreText = document.getElementById('score');
const progressBarFull = document.getElementById('progressBarFull');
const loader = document.getElementById('loader');
const game = document.getElementById('game');
const quizTitle = document.getElementById('quizTitle');
const quizNumber = document.getElementById('quizNumber');
const url = '/quizzes/title/'+quizTitle.innerText;

//get the image by id questionImage
let image = document.getElementById('questionImage').getElementsByTagName('img')[0];
//create the image array for answers
let answerImage1 = document.getElementById('choiceImageTag1');
let answerImage2 = document.getElementById('choiceImageTag2');
let answerImage3 = document.getElementById('choiceImageTag3');
let answerImage4 = document.getElementById('choiceImageTag4');




//save the quiz title in the local storage
localStorage.setItem('quizTitle', quizTitle.innerText);
//save the quiz number in the local storage
localStorage.setItem('quizNumber', quizNumber.innerText); 

let currentQuestion = {};
let acceptingAnswers = false;
let score = 0;
let questionCounter = 0;
let availableQuestions = [];

// CONSTANTS
const CORRECT_BONUS = 10;
let MAX_QUESTIONS = 1;
//url +='/quizzes/'+quizNumber.innerText;
console.log(url);
// Fetching questions from the API
const fetchQuestions = (url) => {
  return fetch(url)
    .then((response) => response.json())
    .then((data) => {
      const loadedQuestions = data.questions;

      // Format the loaded questions
      const formattedQuestions = loadedQuestions.map((loadedQuestion) => {
        const formattedQuestion = {
          question: loadedQuestion.text,
          audioUrl: loadedQuestion.audioUrl, // Add the audio URL property to the question object
          //set the image url from the json file
          imageUrl: loadedQuestion.imageUrl,
          //set the answers image url from the json file
          choices: loadedQuestion.answers.map((answer) => {
            return {
              text: answer.text,
              imageUrl: answer.imageUrl,
            };
          }),
         // choices: loadedQuestion.answers.map((answer) => answer.text),
          correctAnswer: loadedQuestion.correctAnswer,
        };

        return formattedQuestion;
      });

      return formattedQuestions;
    })
    .catch((error) => {
      console.error(error);
    });
};

// Start the quiz game
const startGame = (questions) => {
  questionCounter = 0;
  score = 0;
  availableQuestions = [...questions];
  localStorage.setItem('questions', JSON.stringify([]));

  getNewQuestion();
  game.classList.remove('hidden');
  loader.classList.add('hidden');
  //store an empty array in the local storage for selected answers
  localStorage.setItem('selectedAnswers', JSON.stringify([]));
};

// Get a new question
const getNewQuestion = () => {
  if (availableQuestions.length === 0 || questionCounter >= MAX_QUESTIONS) {
    // Go to the end page or perform any other action
    localStorage.setItem('mostRecentScore', score);
    //go to the end page
    return window.location.assign('./end.html');
  }

  questionCounter++;
  progressText.innerText = `Question ${questionCounter}/${MAX_QUESTIONS}`;
  progressBarFull.style.width = `${(questionCounter / MAX_QUESTIONS) * 100}%`;

  const questionIndex = Math.floor(Math.random() * availableQuestions.length);
  currentQuestion = availableQuestions[questionIndex];
  question.innerHTML = currentQuestion.question;
  //get the question array from the local storage
  let questions = JSON.parse(localStorage.getItem('questions'));
  //add the current question to the question array
  questions.push(currentQuestion);
  //store the question array in the local storage
  localStorage.setItem('questions', JSON.stringify(questions));
  choices.forEach((choice, index) => {
    choice.innerHTML = currentQuestion.choices[index].text;
    //set the image url for the answers
    answerImage1.src = currentQuestion.choices[0].imageUrl;
    answerImage2.src = currentQuestion.choices[1].imageUrl;
    answerImage3.src = currentQuestion.choices[2].imageUrl;
    answerImage4.src = currentQuestion.choices[3].imageUrl;
  });

  // Update the audioPlayer's src attribute with the new audio URL for the current question
  audioPlayer.src = currentQuestion.audioUrl;
  // Update the image's src attribute with the new image URL for the current question
  image.src = currentQuestion.imageUrl;
  //play the audio when the page is loaded
playAudio();

  availableQuestions.splice(questionIndex, 1);
  acceptingAnswers = true;
};

// Handle user's answer selection
const handleChoiceSelection = (event) => {
  if (!acceptingAnswers) return;

  acceptingAnswers = false;
  const selectedChoice = event.target;
  const selectedAnswer = selectedChoice.dataset['number'];

  const classToApply = selectedAnswer - 1 === currentQuestion.correctAnswer ? 'correct' : 'incorrect';

  //store the selected answer in the local storage selectedAnswers
  let selectedAnswers = JSON.parse(localStorage.getItem('selectedAnswers'));
  selectedAnswers.push(selectedAnswer - 1);
  localStorage.setItem('selectedAnswers', JSON.stringify(selectedAnswers));

  if (classToApply === 'correct') {
    incrementScore(CORRECT_BONUS);
  }

  selectedChoice.parentElement.classList.add(classToApply);

  setTimeout(() => {
    selectedChoice.parentElement.classList.remove(classToApply);
    getNewQuestion();
  }, 1000);
};

// Increment the score
const incrementScore = (num) => {
  score += num;
  scoreText.innerText = score;
};

// Usage
//check if the quiz title == Quiz de mathématiques I then fetch the questions
//let fullUrl=url +'/quizzes/title/'+quizTitle.innerText;
//get the quiz from the json file questions-media.json in the data folder 
//let fullUrl = './data/questions-media.json';
 

fetchQuestions(url ).then((questions) => {
  startGame(questions);
});

choices.forEach((choice) => {
  choice.addEventListener('click', handleChoiceSelection);
});

// Path: js\game.js
// show or hide the question image
const showHideQuestionImageButton = document.getElementById('showHideQuestionImageButton');
//add a click event listener to the showHideQuestionImageButton
showHideQuestionImageButton.addEventListener('click', () => {
  //get the question image by id questionImage
  let image = document.getElementById('questionImage');
  //check if the image is hidden
  if (image.style.display === 'none') {
    //show the image
    image.style.display = 'block';
    //change the button text to hide
    showHideQuestionImageButton.innerText = 'Hide';
  } else {
    //hide the image
    image.style.display = 'none';
    //change the button text to show
    showHideQuestionImageButton.innerText = 'Show';
  }
}
);
