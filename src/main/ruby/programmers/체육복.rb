def solution(n, lost, reserve)
  count = lost.length
  lost.each do |num|
      if (idx = reserve.bsearch_index {|x| x == num}) != nil ||
          (idx = reserve.bsearch_index {|x| x == num - 1}) != nil ||
          (idx = reserve.bsearch_index {|x| x == num + 1}) != nil
         count -= 1
          reserve.delete_at(idx)
      end
  end
  
  return n - count
end

puts solution(3, [3], [1])