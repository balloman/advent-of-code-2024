export function solve(lines: string[]) {
  let safeReports = 0;
  for (const line of lines) {
    const levels = line.split(" ");
    if (levels.length < 2) {
      continue;
    }
    if (levels[0] === levels[1]) {
      continue;
    }
    const level1 = Number(levels[0]);
    const level2 = Number(levels[1]);
    if (level2 > level1) {
      let isSafe = true;
      for (let i = 1; i < levels.length; i++) {
        const currentLevel = Number(levels[i]);
        const previousLevel = Number(levels[i - 1]);
        if (currentLevel <= previousLevel) {
          isSafe = false;
        } else if (currentLevel - previousLevel > 3) {
          isSafe = false;
        }
      }
      if (isSafe) safeReports++;
    }
    if (level2 < level1) {
      let isSafe = true;
      for (let i = 1; i < levels.length; i++) {
        const currentLevel = Number(levels[i]);
        const previousLevel = Number(levels[i - 1]);
        if (currentLevel >= previousLevel) {
          isSafe = false;
        } else if (previousLevel - currentLevel > 3) {
          isSafe = false;
        }
      }
      if (isSafe) safeReports++;
    }
  }
  return safeReports;
}

export function solve2(lines: string[]) {
  let safeReports = 0;
  for (const line of lines) {
    const levels = line.split(" ");
    if (levels.length < 2) {
      continue;
    }
    if (levels[0] === levels[1]) {
      continue;
    }
    const level1 = Number(levels[0]);
    const level2 = Number(levels[1]);
    if (level2 > level1) {
      let unsafeNess = 0;
      for (let i = 1; i < levels.length; i++) {
        const currentLevel = Number(levels[i]);
        const previousLevel = Number(levels[i - 1]);
        if (currentLevel <= previousLevel) {
          unsafeNess++;
        } else if (currentLevel - previousLevel > 3) {
          unsafeNess++;
        }
      }
      if (unsafeNess < 2) safeReports++;
    }
    if (level2 < level1) {
      let unsafeNess = 0;
      for (let i = 1; i < levels.length; i++) {
        const currentLevel = Number(levels[i]);
        const previousLevel = Number(levels[i - 1]);
        if (currentLevel >= previousLevel) {
          unsafeNess++;
        } else if (previousLevel - currentLevel > 3) {
          unsafeNess++;
        }
      }
      if (unsafeNess < 2) safeReports++;
    }
  }
  return safeReports;
}

// Learn more at https://docs.deno.com/runtime/manual/examples/module_metadata#concepts
if (import.meta.main) {
  const file = await Deno.readTextFile("./input.txt");
  const lines = file.split("\n");
  console.log(solve(lines));
}
