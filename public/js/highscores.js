//highscores.js
//const portNumber = 8081;
//const url = 'http://localhost:' + portNumber;
const url = "/games";
const highScores = JSON.parse(localStorage.getItem("highScores")) || [];
//get high scores from api localhost:8081/games
/**
 * [
    {
        "id": 1,
        "quizId": 8,
        "quizTitle": "Quiz sur la science et la technologie",
        "playerId": 0,
        "playerNickname": "Omar",
        "score": 50,
        "date": "2023-07-20"
    }
]
 */
const highScoresList = document.getElementById("highScoresList");

fetch(url)
  .then(response => response.json())
  .then(highScores => {
    console.log(highScores);
    //get score.date as human readable
    /*highScores.forEach(score => {
      let date = new Date(score.date);
      score.date = date.toLocaleDateString();
    });*/

    highScoresList.innerHTML = highScores
      .map(score => {
        return `<tr><td>${score.playerNickname}</td><td>${score.quizTitle}</td><td>${score.score}</td><td>${getReadibleDate(score.date)}</td></tr>`;
      })
      .join("");
  });

function getReadibleDate(dateScore) {
  let readableDate = new Date(dateScore).toLocaleDateString();
  //define readible time
  let readableTime = new Date(dateScore).toLocaleTimeString();
  return readableDate + " " + readableTime;
}
//