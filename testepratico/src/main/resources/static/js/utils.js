function maskCpf(e){
    e.maxLenght = "14";
    let inputLength = e.value.length
    // MAX LENGHT 14  CPF
    if (inputLength == 3 || inputLength == 7) {
        e.value += '.'
    }else if (inputLength == 11) {
        e.value += '-'
    }
}
