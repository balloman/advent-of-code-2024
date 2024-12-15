import { assertEquals } from "jsr:@std/assert";
import { solve, solve2 } from "./main.ts";

Deno.test("solve", () => {
  const lines = [
    "7 6 4 2 1",
    "1 2 7 8 9",
    "9 7 6 2 1",
    "1 3 2 4 5",
    "8 6 4 4 1",
    "1 3 6 7 9",
  ];
  assertEquals(solve(lines), 2);
  assertEquals(solve2(lines), 4);
});
