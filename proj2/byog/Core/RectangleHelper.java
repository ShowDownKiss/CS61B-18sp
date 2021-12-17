package byog.Core;

import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

public class RectangleHelper {

    /** Return four corner points.
     * 3 . . . 2
     * .       .
     * .       .
     * .       .
     * 0 . . . 1
     */

    public static Position[] cornerPosition(Position p, int width, int height) {
        Position[] pArray = new Position[4];
        pArray[0] = new Position(p.x, p.y);
        pArray[1] = new Position(p.x + width - 1, p.y);
        pArray[2] = new Position(p.x + width - 1, p.y + height - 1);
        pArray[3] = new Position(p.x, p.y + height - 1);

        return pArray;
    }

    /** Return four orthogonally-adjacent positions.
     *      3
     *    0 p 2
     *      1
     */
    public  static Position[] aroundPositions(Position p) {
        Position[] pArray = new Position[4];
        pArray[0] = new Position(p.x - 1, p.y);
        pArray[1] = new Position(p.x, p.y - 1);
        pArray[2] = new Position(p.x + 1, p.y);
        pArray[3] = new Position(p.x, p.y + 1);
        return pArray;
    }

    public boolean isOnEdge(Position p, TETile[][] world) {
        return p.x == 0 || p.y == 0 || p.x == world.length - 1|| p.y == world[0].length - 1;
    }

    public boolean isInDeadEnd(Position p, TETile[][] world) {
        int exits = 0;
        Position[] pArray = aroundPositions(p);
        for (int i = 0; i < 4; i++) {
            if (world[pArray[i].x][pArray[i].y] == Tileset.FLOOR) {
                exits++;
            }
        }
        return exits == 1;
    }
}
