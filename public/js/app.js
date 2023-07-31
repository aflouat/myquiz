const app = Vue.createApp({});
app.component('header-component', {
  template: `
    <header>
      <!-- Load the content of header.html here -->
      <div>
        <!-- Content of header.html -->
        <ul class="nav justify-content-center">
    <li class="nav-item">
      <a class="nav-link active" href="./index.html">Home</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="./game.html">Play</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="./highscores.html">High Scores</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="./aboutus.html">About Us</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="./contactus.html">Contact Us</a>
    </li>
  </ul>
  

        
      </div>
    </header>
  `,
});

app.component('content-component', {
  template: `
    <main>
      <!-- Load the content of content.html here -->
      <div>
        <!-- Content of content.html -->
        <div class="container">
    <div id="home" class="flex-center flex-column">
      <h1>Liste des Quiz, à vous de jouer</h1>
      <a class="btn" href="./game.html">mathématiques I</a>
      <a class="btn" href="./game-2.html">système solaire</a>
      <a class="btn" href="./game-3.html">étude de la langue</a>
      <a class="btn" href="./game-4.html">histoire de la France</a>
      <a class="btn" href="./game-5.html">histoire de la France pendant l'âge industriel</a>
      <a class="btn" href="./game-6.html">géographie</a>
      <a class="btn" href="./game-7.html">Enseignement moral et civique</a>
      <a class="btn" href="./game-8.html">science et technologie</a>
      <a class="btn" href="./game-9.html">Excel</a>
      <a class="btn" href="./game-10.html">Legumes</a>

      <a class="btn" href="./highscores.html">High Scores</a>
    </div>
  </div>
  
      </div>
    </main>
  `,
});

app.component('footer-component', {
  template: `
    <footer>
      <!-- Load the content of footer.html here -->
      <div>
        <!-- Content of footer.html -->
      </div>
    </footer>
  `,
});

app.mount('#app');
