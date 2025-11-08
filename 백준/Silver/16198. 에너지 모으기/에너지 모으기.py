N = int(input())
numbers = list(map(int, input().split()))

def dfs(nums):
    if len(nums) == 2:
        return 0
    best = 0
    for i in range(1, len(nums) - 1):
        gain = nums[i-1] * nums[i+1]
        next_nums = nums[:i] + nums[i+1:]
        val = gain + dfs(next_nums)
        best = max(best, val)
    return best

result = dfs(numbers)
print(result)