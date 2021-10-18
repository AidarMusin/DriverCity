function checkField() {
    const fileds = document.querySelectorAll('#field');
    let isNull = false;
    fileds.forEach(item => {
        if (item.value)
            isNull = true;
    })

    if (!isNull)
        alert('Заполните хотя бы одно из полей!');
}

const checkedForm = document.querySelector('#checkedForm');
checkedForm.addEventListener('submit', checkField);