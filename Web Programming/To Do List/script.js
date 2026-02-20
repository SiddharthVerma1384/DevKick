const addBtn = document.getElementById("addTaskBtn");
const container = document.getElementById("taskContainer");
const completedCountEl = document.getElementById("completedCount");

let tasks = [];
let completedCount = 0;

/* ---------- Populate Time Dropdowns ---------- */
function populateTime() {
  const hourSelects = ["startHour", "endHour"];
  const minSelects = ["startMin", "endMin"];

  hourSelects.forEach(id => {
    const sel = document.getElementById(id);
    for (let i = 1; i <= 12; i++) {
      const opt = document.createElement("option");
      opt.value = i;
      opt.textContent = i.toString().padStart(2, "0");
      sel.appendChild(opt);
    }
  });

  minSelects.forEach(id => {
    const sel = document.getElementById(id);
    for (let i = 0; i < 60; i++) {
      const opt = document.createElement("option");
      opt.value = i;
      opt.textContent = i.toString().padStart(2, "0");
      sel.appendChild(opt);
    }
  });
}

populateTime();

/* ---------- Time Conversion ---------- */
function toMinutes(hr, min, ampm) {
  hr = Number(hr);
  min = Number(min);

  if (ampm === "PM" && hr !== 12) hr += 12;
  if (ampm === "AM" && hr === 12) hr = 0;

  return hr * 60 + min;
}

/* ---------- Add Task ---------- */
addBtn.addEventListener("click", () => {
  const text = document.getElementById("taskInput").value.trim();
  if (!text) return;

  const sh = startHour.value;
  const sm = startMin.value;
  const sap = startAmPm.value;
  const eh = endHour.value;
  const em = endMin.value;
  const eap = endAmPm.value;

  if (!sh || !sm || !eh || !em) {
    alert("Please select proper time.");
    return;
  }

  const startTotal = toMinutes(sh, sm, sap);

  const taskObj = {
    text,
    startTotal,
    sh, sm, sap,
    eh, em, eap,
    status: "pending"
  };

  tasks.push(taskObj);
  tasks.sort((a, b) => a.startTotal - b.startTotal);

  renderTasks();
  taskInput.value = "";
});

/* ---------- Render Tasks ---------- */
function renderTasks() {
  container.innerHTML = "";

  tasks.forEach((task, index) => {
    const div = document.createElement("div");
    div.className = "task";

    if (task.status === "completed") div.classList.add("completed");
    if (task.status === "rejected") div.classList.add("rejected");

    div.innerHTML = `
      <div>
        <strong>${task.text}</strong><br>
        ${task.sh}:${task.sm} ${task.sap} - ${task.eh}:${task.em} ${task.eap}
      </div>

      <div class="task-buttons">
        <button onclick="markDone(${index})">✓</button>
        <button onclick="markReject(${index})">✗</button>
        <button onclick="editTask(${index})">Edit</button>
        <button onclick="deleteTask(${index})">Delete</button>
      </div>
    `;

    container.appendChild(div);
  });
}

/* ---------- Actions ---------- */
function markDone(i) {
  if (tasks[i].status !== "completed") completedCount++;
  tasks[i].status = "completed";
  updateCounter();
  renderTasks();
}

function markReject(i) {
  if (tasks[i].status === "completed") completedCount--;
  tasks[i].status = "rejected";
  updateCounter();
  renderTasks();
}

function deleteTask(i) {
  if (tasks[i].status === "completed") completedCount--;
  tasks.splice(i, 1);
  updateCounter();
  renderTasks();
}

function editTask(i) {
  const newText = prompt("Edit task:", tasks[i].text);
  if (newText && newText.trim()) {
    tasks[i].text = newText.trim();
    renderTasks();
  }
}

function updateCounter() {
  completedCountEl.innerText = `Completed: ${completedCount}`;
}
