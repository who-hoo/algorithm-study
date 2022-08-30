function solution(arr) {
  let zero = 0;
  let one = 0;

  function recursion(row, col, size){
    let bool = true;
    let node = arr[row][col];
    for(let i=row; i< row+size; i++){
      for(let j=col; j<col+size; j++){
        if(node !== arr[i][j]){
          bool = false;
          break;
        }
      }
    }
    if(bool){
      if(node === 1) one++;
      else zero++;
      return;
    }
    recursion(row, col, size/2);
    recursion(row, col+size/2, size/2);
    recursion(row+size/2, col, size/2);
    recursion(row+size/2, col+size/2, size/2);
  }
  recursion(0,0, arr.length)

  return [zero, one];
}

// 재귀 함수를 통해 문제 해결
// 1. 각 영역의 숫자들이 같은지 검사한다.
// 2. 같을 경우 해당 값으로 카운트
// 3. 다를 경우 반으로 쪼개서 해당 작업 실행.