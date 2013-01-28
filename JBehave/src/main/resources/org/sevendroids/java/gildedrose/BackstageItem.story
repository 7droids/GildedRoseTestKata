Given is a Backstage item with sellin = 11 and quality = 1
When I update the item
Then sellin = 10 and quality = 2

When I update the item
Then sellin = 9 and quality = 4

Given is a Backstage item with sellin = 6 and quality = 44
When I update the item
Then sellin = 5 and quality = 46

When I update the item
Then sellin = 4 and quality = 49

When I update the item
Then sellin = 3 and quality = 50

Given is a Backstage item with sellin = 1 and quality = 44
When I update the item
Then sellin = 0 and quality = 47

When I update the item
Then sellin = -1 and quality = 0
