def solution(answers)
  answer = []
  
  rule1 = [1,2,3,4,5]
  rule2 = [2,1,2,3,2,4,2,5]
  rule3 = [3,3,1,1,2,2,4,4,5,5]
  
  scores = [0,0,0]
  
  answers.each_with_index do |number, index|
    if number == rule1[index % rule1.length]
      scores[0] += 1
    end
      
    if number == rule2[index % rule2.length]
      scores[1] += 1
    end
    
    if number == rule3[index % rule3.length]
      scores[2] += 1
    end
  end

  max = scores.max

  scores.each_with_index do |score, index|
    if score == max
      answer.push(index + 1)
    end
  end

  return answer
end