package scaler.test.kavya;

/**
 * Given an XY plane there is a transmitter present at co-ordinates (A,B) and N receivers at co-ordinates (C[i],D[i]).
 * when the transmitter broadcasts a message,it transmits in all directions with equal velocity.Find the order in which
 * receiver receives message.
 * Note:If the two receivers receives the message at the same time,place one with higher abscisaa(x co-ordinate)
 * before the other.And if they have the same abscissa then sort them based on their input index.
 *
 * problem constraints
 * 1<=N<=100000
 * -10^9<=A,B,C[i],D[i]<=10^9
 *
 * Input format:
 * first argument of integer is single character A.
 * second is Single integer B
 * third is integer array C
 * Integer array D
 * Output: order in which receivers receive the message
 *
 * Example 1: input: A=0,B=0,C=[1,2,3] D= [2,3,1]
 * output:[1,3,2]
 * example 2: input:A=1,B=1,C=[0,2] , D=[0,2]
 * output:[2,1]
 *
 * Explanation 1:
 * distance to point (1,2) =sqrt(5)
 * distance to point (2,3) =sqrt(13)
 * distance to point (3,1) =sqrt(10)
 * so first message reach to (1,2), then to (3,1) and then (2,3)
 *
 * @author kavya k on 01-Mar-2020
 */
public class TransmittingSignal {
}
