package com.balloman

import java.nio.file.Files
import java.nio.file.Paths
import kotlin.math.absoluteValue

data class Input(val list1: List<Int>, val list2: List<Int>)

fun main() {
  val inputLines = Files.readAllLines(Paths.get("input.txt")).toList()
  val set1 = mutableListOf<Int>()
  val set2 = mutableListOf<Int>()

  for (line in inputLines) {
    val numbers = line.split("   ")
    set1.add(numbers[0].toInt())
    set2.add(numbers[1].toInt())
  }
  val input = Input(set1, set2)
  val part1Answer = part1(input)
  val part2Answer = part2(input)

  println("Part 1: $part1Answer")
  println("Part 2: $part2Answer")
}

fun part1(input: Input): Int {

  val sortedList1 = input.list1.sorted()
  val sortedList2 = input.list2.sorted()
  var sum = 0
  for (i in sortedList1.indices) {
    sum += (sortedList1[i] - sortedList2[i]).absoluteValue
  }
  return sum
}

fun part2(input: Input): Int {
  val sortedList2 = input.list2.sorted()
  val countMap = mutableMapOf<Int, Int>()

  for (i in sortedList2.indices) {
    val current = sortedList2[i]
    countMap[current] = countMap.getOrDefault(current, 0) + 1
  }

  var sum = 0
  for (i in input.list1.indices) {
    sum += countMap.getOrDefault(input.list1[i], 0) * input.list1[i]
  }
  return sum
}

// Part 1
/**
 * For example:
 *
 * 3 4 4 3 2 5 1 3 3 9 3 3 Maybe the lists are only off by a small amount! To find out, pair up the
 * numbers and measure how far apart they are. Pair up the smallest number in the left list with the
 * smallest number in the right list, then the second-smallest left number with the second-smallest
 * right number, and so on.
 *
 * Within each pair, figure out how far apart the two numbers are; you'll need to add up all of
 * those distances. For example, if you pair up a 3 from the left list with a 7 from the right list,
 * the distance apart is 4; if you pair up a 9 with a 3, the distance apart is 6.
 *
 * In the example list above, the pairs and distances would be as follows:
 *
 * The smallest number in the left list is 1, and the smallest number in the right list is 3. The
 * distance between them is 2. The second-smallest number in the left list is 2, and the
 * second-smallest number in the right list is another 3. The distance between them is 1. The
 * third-smallest number in both lists is 3, so the distance between them is 0. The next numbers to
 * pair up are 3 and 4, a distance of 1. The fifth-smallest numbers in each list are 3 and 5, a
 * distance of 2. Finally, the largest number in the left list is 4, while the largest number in the
 * right list is 9; these are a distance 5 apart. To find the total distance between the left list
 * and the right list, add up the distances between all of the pairs you found. In the example
 * above, this is 2 + 1 + 0 + 1 + 2 + 5, a total distance of 11!
 */
