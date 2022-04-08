# 1 Lab 09-Treeburning Report

#### 1) Board Size
I decided to use the board size of 100x100 as I felt that it would best represent a board that isn't too small and neither too big. This allowed for faster runtime results as the function had to be called multiple times.

#### 2) # of Repetitions
I chose to use 100 repetitions due to the similar reason as my choice for board size. I thought that this value will allow for reasonable runtime and will be enough to find the mean (average of 100 values). Furthermore, by using 100 repetitions, I would be able to have more accurate results without compromising on time. Since the board is 100x100, having more repetitions would not be viable. Likewise, if the board was smaller, having more repetitions on a less accurate sample space would be detrimental as well.

#### 3) Changing Board Size
By changing the board size, average burn time increases proportionally for each density. (E.g small board = smaller average run times). However, MAX burn time acts inversely proportional to board size -> See below.

#### 4) Relationship Between Board Size and Max Burn Time
Maximum burn time seems to be inversely proportional to board size. I tested this by creating multiple tables that changed the board size (incremented & decremented). Then, I looked at the maximum burn times to determine the relationship between the times and the size.

#### 5) Highest Burn Time Density
For a board size of 100x100, The density of **62%** yields the highest burn time. When the test is run multiple times, the max burn time can vary from 61-62% inclusive. Overall, as the board size approaches 1000 x 1000, the max burn time seems to get closer to the range of 60-63%

### 100 Repetitions on Size 100x100

| Density        | Average Burn Time       |
| ------------- |:-------------:|
| 5%   | 1.31                   |
| 10%   | 1.98    |
| 15%   | 3.02   |
| 20%   | 3.84   |
| 25%   | 5.13   |
| 30%   | 6.87   |
| 35%   | 8.3   |
| 40%   | 11.47   |
| 45%   | 18.57   |
| 50%   | 33.85   |
| 55%   | 60.39   |
| 60%   | 187.05   |
| 65%   | 176.91   |
| 70%   | 145.43   |
| 75%   | 130.84   |
| 80%   | 122.56   |
| 85%   | 115.98   |
| 90%   | 110.79   |
| 95%   | 106.12   |

### 100 Repetitions on Size 100x100 (Density 55%-65%)

| Density        | Average Burn Time       |
| ------------- |:-------------:|
| 55%   | 64.47   |
| 56%   | 86.47   |
| 57%   | 106.92   |
| 58%   | 141.27   |
| 59%   | 159.48   |
| 60%   | 188.61   |
| 61%   | 196.71   |
| 62%   | 211.06   |
| 63%   | 194.28   |
| 64%   | 183.61   |
| 65%   | 173.88   |
