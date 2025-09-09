package com.vn.nhat.algorithm.factory;

public abstract class Problem<I, O> {

  private final Level level;
  private final String description;

  /**
   * Constructor for the object LeetCodeProblem.
   *
   * @param level       the level of the problem
   * @param description the description of the problem
   */
  protected Problem(Level level, String description) {
    this.level = level;
    this.description = description;
  }

  /**
   * Get the level of the problem.
   *
   * @return the level of the problem
   */
  public Level getLevel() {
    return this.level;
  }

  /**
   * Get the description of the problem.
   *
   * @return the description of the problem
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * Brute force solution.
   *
   * @param input the input for the problem
   * @return the output of the problem
   */
  public abstract O bruteForce(I input);

  /**
   * The real solution for the problem, this should lower than O(n^2) in time complexity and O(1) in
   * space complexity.
   *
   * @param input the input for the problem
   * @return the output of the problem
   */
  public abstract O solution(I input);
}
