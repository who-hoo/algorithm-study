function solution(queue1, queue2) {
    
    let numbers = [...queue1,...queue2];
    let queueSum = queue1.reduce((c,a) => c+a);
    let targetNum = numbers.reduce((c,a) => c+a)/2;

    let p1 = 0, p2 = queue1.length;
    let result = 0;

    while(result <= numbers.length*2){
        if(queueSum === targetNum) {
            return result;
        }

        if(queueSum > targetNum){
            queueSum -= numbers[p1];
            p1++;
        }else{
            queueSum += numbers[p2];
            p2++;
        }
        result++;
    }

    return -1;
    
}
