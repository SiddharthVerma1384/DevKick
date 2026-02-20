// ================= DATA =================
const quizData = [
  {
    question: "Which language runs in the browser?",
    options: ["Java", "Python", "JavaScript", "C++"],
    correct: 2
  },
  {
    question: "Which is used for styling web pages?",
    options: ["HTML", "CSS", "Node.js", "MongoDB"],
    correct: 1
  },
  {
    question: "Which database is NoSQL?",
    options: ["MySQL", "MongoDB", "PostgreSQL", "Oracle"],
    correct: 1
  },
  {
    question: "React is primarily used for?",
    options: ["Database", "UI", "Server", "Networking"],
    correct: 1
  },
  {
    question: "Node.js is used for?",
    options: ["Frontend", "Backend", "Styling", "Design"],
    correct: 1
  }
];

let current = 0;
let userAnswers = new Array(quizData.length).fill(null);
let submitted = new Array(quizData.length).fill(false);
let timeLeft = 60;
let timer;

// DOM
const questionArea = document.getElementById("questionArea");
const prevBtn = document.getElementById("prevBtn");
const nextBtn = document.getElementById("nextBtn");
const submitQ = document.getElementById("submitQuestion");
const attemptedEl = document.getElementById("attempted");
const leftEl = document.getElementById("left");
const qNumbers = document.getElementById("questionNumbers");
const finalSubmit = document.getElementById("finalSubmit");
const modal = document.getElementById("modal");
const modalContent = document.getElementById("modalContent");
const timerEl = document.getElementById("timer");

// INIT numbers
function initNumbers() {
  qNumbers.innerHTML = "";
  quizData.forEach((_, i) => {
    const box = document.createElement("div");
    box.className = "q-box";
    box.id = "qbox-" + i;
    box.textContent = i + 1;
    qNumbers.appendChild(box);
  });
}

function loadQuestion() {
  const q = quizData[current];

  questionArea.innerHTML = `
    <h3>Q${current + 1}. ${q.question}</h3>
    ${q.options
      .map(
        (opt, i) => `
      <label>
        <input type="radio" name="opt" value="${i}"
          ${userAnswers[current] === i ? "checked" : ""}>
        ${opt}
      </label><br/>
    `
      )
      .join("")}
  `;

  prevBtn.disabled = current === 0;
  nextBtn.disabled = current === quizData.length - 1;
}

function updateStats() {
  const attempted = submitted.filter(Boolean).length;
  attemptedEl.textContent = attempted;
  leftEl.textContent = quizData.length - attempted;

  submitted.forEach((s, i) => {
    const box = document.getElementById("qbox-" + i);
    if (box) box.style.display = s ? "none" : "flex";
  });
}

// TIMER
function startTimer() {
  timer = setInterval(() => {
    timeLeft--;
    const m = String(Math.floor(timeLeft / 60)).padStart(2, "0");
    const s = String(timeLeft % 60).padStart(2, "0");
    timerEl.textContent = `${m}:${s}`;

    if (timeLeft <= 0) {
      clearInterval(timer);
      finishQuiz();
    }
  }, 1000);
}

// EVENTS
questionArea.addEventListener("change", (e) => {
  if (e.target.name === "opt") {
    userAnswers[current] = Number(e.target.value);
  }
});

submitQ.onclick = () => {
  if (userAnswers[current] === null) return;
  submitted[current] = true;
  updateStats();
  if (current < quizData.length - 1) {
    current++;
    loadQuestion();
  }
};

prevBtn.onclick = () => {
  current--;
  loadQuestion();
};

nextBtn.onclick = () => {
  current++;
  loadQuestion();
};

finalSubmit.onclick = () => {
  showModal(`
    <h3>Confirm Submission</h3>
    <p>Attempted: ${submitted.filter(Boolean).length}</p>
    <p>Left: ${quizData.length - submitted.filter(Boolean).length}</p>
    <button class="btn-3d primary" onclick="finishQuiz()">Submit</button>
    <button class="btn-3d" onclick="closeModal()">Continue Quiz</button>
  `);
};

// FINISH
function finishQuiz() {
  clearInterval(timer);

  let score = 0;
  quizData.forEach((q, i) => {
    if (userAnswers[i] === q.correct) score++;
  });

  showModal(`
    <h2>Quiz Over</h2>
    <p>Score: ${score}/${quizData.length}</p>
    <button class="btn-3d primary" onclick="reviewQuiz()">Review Quiz</button>
  `);
}

function reviewQuiz() {
  let score = 0;
  let html = `<h3>Review</h3><div class="review-list">`;

  quizData.forEach((q, i) => {
    if (userAnswers[i] === q.correct) score++;

    html += `<p><b>Q${i + 1}. ${q.question}</b></p>`;
    q.options.forEach((opt, j) => {
      let cls = "";
      if (userAnswers[i] === j) {
        cls = j === q.correct ? "correct" : "wrong";
      }
      html += `<div class="${cls}">${opt}</div>`;
    });
  });

  html += `</div>`;

  if (score === quizData.length) {
    html += `<button class="btn-3d primary" onclick="exitQuiz()">Done</button>`;
  } else {
    html += `
      <button class="btn-3d primary" onclick="exitQuiz()">End Quiz</button>
      <button class="btn-3d" onclick="reattempt()">Reattempt Quiz</button>
    `;
  }

  showModal(html);
}

function exitQuiz() {
  location.reload();
}

function reattempt() {
  location.reload();
}

// MODAL
function showModal(html) {
  modalContent.innerHTML = html;
  modal.classList.remove("hidden");
}

function closeModal() {
  modal.classList.add("hidden");
}

// START
initNumbers();
loadQuestion();
updateStats();
startTimer();