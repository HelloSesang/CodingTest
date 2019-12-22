def solution(array, commands)
  answer = []
  
  commands.each do |command|
      len = command[1] - command[0] + 1
      result = array.slice(command[0] - 1 , len).sort[command[2] - 1]
      answer.push(result)
  end
  
  return answer
end