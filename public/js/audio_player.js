const audioPlayer = document.getElementById('audioPlayer');
const playButton = document.getElementById('playButton'); // Add this line to get the play button element

// Function to play the audio
function playAudio() {
  audioPlayer.play();
}

// Function to pause the audio
function pauseAudio() {
  audioPlayer.pause();
}

// Add a click event listener to the play button to play the audio when clicked
playButton.addEventListener('click', () => {
  playAudio();
});



