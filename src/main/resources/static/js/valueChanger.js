const p_min_value = document.getElementById('p-min-value');
const p_max_value = document.getElementById('p-max-value');
const q_min_value = document.getElementById('q-min-value');
const q_max_value = document.getElementById('q-max-value');
const e_min_value = document.getElementById('e-min-value');

p_min_value.addEventListener('input', (event) => {
    let current_field = document.getElementById('p-min');
    let max_value = parseInt(p_max_value.value);
    if (parseInt(p_min_value.value) >= max_value - 1){
        p_min_value.value = max_value - 1;
    }
    current_field.textContent = `p(${event.target.value})`;
});

p_max_value.addEventListener('input', (event) => {
    let current_field = document.getElementById('p-max');
    let min_value = parseInt(p_min_value.value);
    if (parseInt(p_max_value.value) <= min_value + 1){
        p_max_value.value = min_value + 1;
    }
    current_field.textContent = `p(${event.target.value})`;
});

q_min_value.addEventListener('input', (event) => {
    let current_field = document.getElementById('q-min');
    let max_value = parseInt(q_max_value.value);
    if (parseInt(q_min_value.value) >= max_value - 1){
        q_min_value.value = max_value - 1;
    }
    current_field.textContent = `p(${event.target.value})`;
});

q_max_value.addEventListener('input', (event) => {
    let current_field = document.getElementById('q-max');
    let min_value = parseInt(q_min_value.value);
    if (parseInt(q_max_value.value) <= min_value + 1){
        q_max_value.value = min_value + 1;
    }
    current_field.textContent = `p(${event.target.value})`;
});

e_min_value.addEventListener('input', (event) => {
    let current_field = document.getElementById('e-min');
    current_field.textContent = `Нижняя граница e (${event.target.value})`;
});