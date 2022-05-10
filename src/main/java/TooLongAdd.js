function add(a, b){
    var arrA = a.split('').reverse().map(i => parseInt(i))
    var arrB = b.split('').reverse().map(i => parseInt(i))
    var maxLen = arrA.length>=arrB.length?arrA.length:arrB.length
    for(var i = 0;i < maxLen; i++){
        arrA[i] = arrA[i] !== undefined?arrA[i]: 0
    }
    for(var i = 0;i < maxLen; i++){
        arrB[i] = arrB[i] !== undefined?arrB[i]: 0
    }
    var resultArr = new Array()
    for(var i = 0;i <= maxLen;i++ ){
        resultArr[i] = 0
    }
    for(var i = 0;i < maxLen;i++){
        var temp = resultArr[i]
        temp += arrA[i]
        temp += arrB[i]
        if(temp >=10){
            temp -= 10
            resultArr[i+1] = 1
        }
        resultArr[i] = temp
    }

    if(resultArr[resultArr.length - 1] === 0){
        resultArr.pop()
    }
    resultArr = resultArr.reverse()
    return resultArr.join('')
}
function sumBigNums(a,b){
    let carry = 0, res = ' ';
    a = a.split("");
    b = b.split("");
    while(a.length || b.length || carry){
        carry += ~~a.pop() + ~~b.pop();
        res = (carry%10) + res;
        carry = carry > 9;
    }
    return res.replace(/^0+/, '');

}

sumBigNums("4442223323234213123124324236748723460283460","748239065024781678026187457016471")
console.log(res)
