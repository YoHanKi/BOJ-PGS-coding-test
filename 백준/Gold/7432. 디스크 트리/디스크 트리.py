import sys
input = sys.stdin.readline

N = int(input())
paths = []
for _ in range(N):
    line = input().strip()
    parts = [p.strip() for p in line.split("\\") if p.strip() != ""]
    paths.append(parts)

class Node:
    __slots__ = ("ch",)
    def __init__(self):
        self.ch = {}

root = Node()

for parts in paths:
    cur = root
    for name in parts:
        if name not in cur.ch:
            cur.ch[name] = Node()
        cur = cur.ch[name]

out_lines = []

def dfs(node: Node, depth: int):
    for name in sorted(node.ch.keys()):
        out_lines.append(" " * depth + name)
        dfs(node.ch[name], depth + 1)

dfs(root, 0)
print("\n".join(out_lines))