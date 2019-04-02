package com.example.mouad.kanjiapp;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RemoteAccess implements AsyncResponse {

    private static final String SERVERADDR = "http://192.168.56.1/KanjiApp/serveurKanjiApp.php";
    ArrayList<Kanji> LesKanjisJSON = new ArrayList<Kanji>();
    ArrayList<UserDistant> LesUserDistants = new ArrayList<UserDistant>();
    ArrayList<Kanji> Kanji_JLPT5_JSONArray = new ArrayList<Kanji>();
    ArrayList<Kanji> Kanji_JLPT4_JSONArray = new ArrayList<Kanji>();
    ArrayList<Kanji> Kanji_JLPT3_JSONArray = new ArrayList<Kanji>();
    ArrayList<Kanji> Kanji_JLPT2_JSONArray = new ArrayList<Kanji>();
    ArrayList<Kanji> Kanji_JLPT1_JSONArray = new ArrayList<Kanji>();
    ArrayList<UserTestHistory> UserTestHistory = new ArrayList<UserTestHistory>();
    ArrayList<Hiragana> Hiragana_ArrayList_Groupe_A = new ArrayList<Hiragana>();
    ArrayList<Hiragana> Hiragana_ArrayList_Groupe_K = new ArrayList<Hiragana>();
    ;
    ArrayList<Hiragana> Hiragana_ArrayList_Groupe_S = new ArrayList<Hiragana>();
    ;
    ArrayList<Hiragana> Hiragana_ArrayList_Groupe_T = new ArrayList<Hiragana>();
    ;
    ArrayList<Hiragana> Hiragana_ArrayList_Groupe_N = new ArrayList<Hiragana>();
    ;
    ArrayList<Hiragana> Hiragana_ArrayList_Groupe_H = new ArrayList<Hiragana>();
    ;
    ArrayList<Hiragana> Hiragana_ArrayList_Groupe_M = new ArrayList<Hiragana>();
    ;
    ArrayList<Hiragana> Hiragana_ArrayList_Groupe_Y = new ArrayList<Hiragana>();
    ;
    ArrayList<Hiragana> Hiragana_ArrayList_Groupe_R = new ArrayList<Hiragana>();
    ;
    ArrayList<Hiragana> Hiragana_ArrayList_Groupe_W = new ArrayList<Hiragana>();
    ;
    ArrayList<Hiragana> Hiragana_ArrayList_Groupe_0 = new ArrayList<Hiragana>();
    ;

    ArrayList<Katakana> Katakana_ArrayList_Groupe_A = new ArrayList<Katakana>();
    ArrayList<Katakana> Katakana_ArrayList_Groupe_K = new ArrayList<Katakana>();
    ;
    ArrayList<Katakana> Katakana_ArrayList_Groupe_S = new ArrayList<Katakana>();
    ;
    ArrayList<Katakana> Katakana_ArrayList_Groupe_T = new ArrayList<Katakana>();
    ;
    ArrayList<Katakana> Katakana_ArrayList_Groupe_N = new ArrayList<Katakana>();
    ;
    ArrayList<Katakana> Katakana_ArrayList_Groupe_H = new ArrayList<Katakana>();
    ;
    ArrayList<Katakana> Katakana_ArrayList_Groupe_M = new ArrayList<Katakana>();
    ;
    ArrayList<Katakana> Katakana_ArrayList_Groupe_Y = new ArrayList<Katakana>();
    ;
    ArrayList<Katakana> Katakana_ArrayList_Groupe_R = new ArrayList<Katakana>();
    ;
    ArrayList<Katakana> Katakana_ArrayList_Groupe_W = new ArrayList<Katakana>();
    ;
    ArrayList<Katakana> Katakana_ArrayList_Groupe_0 = new ArrayList<Katakana>();
    ;
    int i;

    public RemoteAccess() {
        super();
    }

    @Override
    public void processFinish(String output) {
        Log.d("serveur", "*************************" + output);
        String[] message = output.split("%");
        if (message.length > 1) {
            if (message[0].equals("enreg")) {
                Log.d("enreg", "******************" + message[1]);
            } else {
                if (message[0].equals("AllUsers")) {
                    Log.d("AllUsers", "******************" + message[1]);
                    try {
                        JSONArray jsonInfo = new JSONArray(message[1]);
                        for (i = 0; i < jsonInfo.length(); i++) {
                            JSONObject info = new JSONObject(jsonInfo.get(i).toString());
                            String EmailAddress = info.getString("EmailAddress");
                            String Password = info.getString("Password");
                            String Pseudo = info.getString("Pseudo");
                            UserDistant userDistant = new UserDistant(EmailAddress, Password, Pseudo);
                            LesUserDistants.add(userDistant);
                        }
                        SignInUserActivity.setLesUserDistants(LesUserDistants);
                    } catch (JSONException e) {
                        Log.d("erreur", "******************" + message[1]);
                    }
                }
                if (message[0].equals("TousLesKanjis")) {
                    Log.d("TousLesKanjis", "******************" + message[1]);
                    try {
                        JSONArray jsonInfo = new JSONArray(message[1]);
                        for (i = 0; i < jsonInfo.length(); i++) {
                            JSONObject info = new JSONObject(jsonInfo.get(i).toString());
                            Integer ID = info.getInt("ID");
                            String CHARACTERE = info.getString("CHARACTERE");
                            Integer JLPT_NUMERO = info.getInt("JLPT_NUMERO");
                            String SIGNIFICATION = info.getString("SIGNIFICATION");
                            String LECTURE_KUN = info.getString("LECTURE_KUN");
                            String LECTURE_ON = info.getString("LECTURE_ON");
                            Kanji kanji = new Kanji(CHARACTERE, JLPT_NUMERO, SIGNIFICATION, LECTURE_KUN, LECTURE_ON);
                            if (kanji.getNumero() == 5) {
                                Kanji_JLPT5_JSONArray.add(kanji);
                            }
                            if (kanji.getNumero() == 4) {
                                Kanji_JLPT4_JSONArray.add(kanji);
                            }
                            if (kanji.getNumero() == 3) {
                                Kanji_JLPT3_JSONArray.add(kanji);
                            }

                            if (kanji.getNumero() == 2) {
                                Kanji_JLPT2_JSONArray.add(kanji);
                            }

                            if (kanji.getNumero() == 1) {
                                Kanji_JLPT1_JSONArray.add(kanji);
                            }
                            LesKanjisJSON.add(kanji);
                        }
                        Admin.setLesKanjis(LesKanjisJSON);
                        Before_SecondScreen.setKanji_JLPT5_ArrayList(Kanji_JLPT5_JSONArray);
                        Before_SecondScreen.setKanji_JLPT4_ArrayList(Kanji_JLPT4_JSONArray);
                        Before_SecondScreen.setKanji_JLPT3_ArrayList(Kanji_JLPT3_JSONArray);
                        Before_SecondScreen.setKanji_JLPT2_ArrayList(Kanji_JLPT2_JSONArray);
                        Before_SecondScreen.setKanji_JLPT1_ArrayList(Kanji_JLPT1_JSONArray);
                        Learn_Kanji.setKanji_JLPT5_ArrayList(Kanji_JLPT5_JSONArray);
                        Learn_Kanji.setKanji_JLPT4_ArrayList(Kanji_JLPT4_JSONArray);
                        Learn_Kanji.setKanji_JLPT3_ArrayList(Kanji_JLPT3_JSONArray);
                        Learn_Kanji.setKanji_JLPT2_ArrayList(Kanji_JLPT2_JSONArray);
                        Learn_Kanji.setKanji_JLPT1_ArrayList(Kanji_JLPT1_JSONArray);
                    } catch (JSONException e) {
                        Log.d("erreur", "******************" + message[1]);
                    }
                }
                if (message[0].equals("NewUser")) {
                    Log.d("NewUser", "******************" + message[1]);
                }
                if (message[0].equals("insert_test_history")) {
                    Log.d("insert_test_history", "******************" + message[1]);
                }
                if (message[0].equals("LogUser")) {
                    Log.d("LogUser", "******************" + message[1]);
                    try {
                        JSONArray jsonInfo = new JSONArray(message[1]);
                        for (i = 0; i < jsonInfo.length(); i++) {
                            JSONObject info = new JSONObject(jsonInfo.get(i).toString());
                            String EmailAddress = info.getString("EmailAddress");
                            String Password = info.getString("Password");
                            String Pseudo = info.getString("Pseudo");
                            UserDistant userDistant = new UserDistant(EmailAddress, Password, Pseudo);
                            LesUserDistants.add(userDistant);
                        }
                        LoginUserActivity.setLesUserDistants(LesUserDistants);
                    } catch (JSONException e) {
                        Log.d("erreur", "******************" + message[1]);
                    }
                }

                if (message[0].equals("HistoryTest")) {
                    Log.d("HistoryTest", "******************" + message[1]);
                    try {
                        JSONArray jsonInfo = new JSONArray(message[1]);
                        for (i = 0; i < jsonInfo.length(); i++) {
                            JSONObject info = new JSONObject(jsonInfo.get(i).toString());
                            String NiveauJLPTTestKanji = info.getString("NIVEAU_JLPT_TEST_KANJI");
                            String DATE_TEST = info.getString("DATE_TEST");
                            Integer SCORE = info.getInt("SCORE");
                            String EmailAddress = info.getString("EmailAddress");
                            UserTestHistory userTestHistory = new UserTestHistory(NiveauJLPTTestKanji, DATE_TEST, SCORE, EmailAddress);
                            UserTestHistory.add(userTestHistory);
                        }
                        Historic_Activity.setLesTestHistoryUsers(UserTestHistory);
                    } catch (JSONException e) {
                        Log.d("erreur", "******************" + message[1]);
                    }
                }


                if (message[0].equals("TousLesKatakana")) {
                    Log.d("TousLesKatakana", "******************" + message[1]);
                    try {
                        JSONArray jsonInfo = new JSONArray(message[1]);
                        for (i = 0; i < jsonInfo.length(); i++) {
                            JSONObject info = new JSONObject(jsonInfo.get(i).toString());
                            Integer ID = info.getInt("ID");
                            String Charactere = info.getString("Charactere");
                            String Signification = info.getString("Signification");
                            String GroupeKatakana = info.getString("GroupeKatakana");
                            Katakana katakana = new Katakana(Charactere, 1, Signification, GroupeKatakana);
                            if (katakana.getGroupeKatakana().equals("a")) {
                                Katakana_ArrayList_Groupe_A.add(katakana);
                            }
                            if (katakana.getGroupeKatakana().equals("Ka")) {
                                Katakana_ArrayList_Groupe_K.add(katakana);
                            }
                            if (katakana.getGroupeKatakana().equals("Sa")) {
                                Katakana_ArrayList_Groupe_S.add(katakana);
                            }
                            if (katakana.getGroupeKatakana().equals("Ta")) {
                                Katakana_ArrayList_Groupe_T.add(katakana);
                            }
                            if (katakana.getGroupeKatakana().equals("Na")) {
                                Katakana_ArrayList_Groupe_N.add(katakana);
                            }
                            if (katakana.getGroupeKatakana().equals("Ha")) {
                                Katakana_ArrayList_Groupe_H.add(katakana);
                            }
                            if (katakana.getGroupeKatakana().equals("Ma")) {
                                Katakana_ArrayList_Groupe_M.add(katakana);
                            }
                            if (katakana.getGroupeKatakana().equals("Ra")) {
                                Katakana_ArrayList_Groupe_R.add(katakana);
                            }
                            if (katakana.getGroupeKatakana().equals("Ya")) {
                                Katakana_ArrayList_Groupe_Y.add(katakana);
                            }
                            if (katakana.getGroupeKatakana().equals("Wa")) {
                                Katakana_ArrayList_Groupe_W.add(katakana);
                            }
                            if (katakana.getGroupeKatakana().equals("N")) {
                                Katakana_ArrayList_Groupe_0.add(katakana);
                            }
                        }
                        Katakana_beforeT.setKatakana_ArrayList_Groupe_A(Katakana_ArrayList_Groupe_A);
                        Katakana_beforeT.setKatakana_ArrayList_Groupe_K(Katakana_ArrayList_Groupe_K);
                        Katakana_beforeT.setKatakana_ArrayList_Groupe_S(Katakana_ArrayList_Groupe_S);
                        Katakana_beforeT.setKatakana_ArrayList_Groupe_T(Katakana_ArrayList_Groupe_T);
                        Katakana_beforeT.setKatakana_ArrayList_Groupe_N(Katakana_ArrayList_Groupe_N);
                        Katakana_beforeT.setKatakana_ArrayList_Groupe_H(Katakana_ArrayList_Groupe_H);
                        Katakana_beforeT.setKatakana_ArrayList_Groupe_M(Katakana_ArrayList_Groupe_M);
                        Katakana_beforeT.setKatakana_ArrayList_Groupe_R(Katakana_ArrayList_Groupe_R);
                        Katakana_beforeT.setKatakana_ArrayList_Groupe_Y(Katakana_ArrayList_Groupe_Y);
                        Katakana_beforeT.setKatakana_ArrayList_Groupe_W(Katakana_ArrayList_Groupe_W);
                        Katakana_beforeT.setKatakana_ArrayList_Groupe_0(Katakana_ArrayList_Groupe_0);
                        Katakana_Learn.setKatakana_ArrayList_Groupe_A(Katakana_ArrayList_Groupe_A);
                        Katakana_Learn.setKatakana_ArrayList_Groupe_K(Katakana_ArrayList_Groupe_K);
                        Katakana_Learn.setKatakana_ArrayList_Groupe_S(Katakana_ArrayList_Groupe_S);
                        Katakana_Learn.setKatakana_ArrayList_Groupe_T(Katakana_ArrayList_Groupe_T);
                        Katakana_Learn.setKatakana_ArrayList_Groupe_N(Katakana_ArrayList_Groupe_N);
                        Katakana_Learn.setKatakana_ArrayList_Groupe_H(Katakana_ArrayList_Groupe_H);
                        Katakana_Learn.setKatakana_ArrayList_Groupe_M(Katakana_ArrayList_Groupe_M);
                        Katakana_Learn.setKatakana_ArrayList_Groupe_R(Katakana_ArrayList_Groupe_R);
                        Katakana_Learn.setKatakana_ArrayList_Groupe_Y(Katakana_ArrayList_Groupe_Y);
                        Katakana_Learn.setKatakana_ArrayList_Groupe_W(Katakana_ArrayList_Groupe_W);
                        Katakana_Learn.setKatakana_ArrayList_Groupe_0(Katakana_ArrayList_Groupe_0);
                    } catch (JSONException e) {
                        Log.d("erreur", "******************" + message[1]);
                    }
                }


                if (message[0].equals("TousLesHiragana")) {
                    Log.d("TousLesHiragana", "******************" + message[1]);
                    try {
                        JSONArray jsonInfo = new JSONArray(message[1]);
                        for (i = 0; i < jsonInfo.length(); i++) {
                            JSONObject info = new JSONObject(jsonInfo.get(i).toString());
                            Integer ID = info.getInt("ID");
                            String Charactere = info.getString("Charactere");
                            String Signification = info.getString("Signification");
                            String GroupeHiragana = info.getString("GroupeHiragana");
                            Hiragana hiragana = new Hiragana(Charactere, 1, Signification, GroupeHiragana);
                            if (hiragana.getGroupeHiragana().equals("a")) {
                                Hiragana_ArrayList_Groupe_A.add(hiragana);
                            }
                            if (hiragana.getGroupeHiragana().equals("Ka")) {
                                Hiragana_ArrayList_Groupe_K.add(hiragana);
                            }
                            if (hiragana.getGroupeHiragana().equals("Sa")) {
                                Hiragana_ArrayList_Groupe_S.add(hiragana);
                            }
                            if (hiragana.getGroupeHiragana().equals("Ta")) {
                                Hiragana_ArrayList_Groupe_T.add(hiragana);
                            }
                            if (hiragana.getGroupeHiragana().equals("Na")) {
                                Hiragana_ArrayList_Groupe_N.add(hiragana);
                            }
                            if (hiragana.getGroupeHiragana().equals("Ha")) {
                                Hiragana_ArrayList_Groupe_H.add(hiragana);
                            }
                            if (hiragana.getGroupeHiragana().equals("Ma")) {
                                Hiragana_ArrayList_Groupe_M.add(hiragana);
                            }
                            if (hiragana.getGroupeHiragana().equals("Ra")) {
                                Hiragana_ArrayList_Groupe_R.add(hiragana);
                            }
                            if (hiragana.getGroupeHiragana().equals("Ya")) {
                                Hiragana_ArrayList_Groupe_Y.add(hiragana);
                            }
                            if (hiragana.getGroupeHiragana().equals("Wa")) {
                                Hiragana_ArrayList_Groupe_W.add(hiragana);
                            }
                            if (hiragana.getGroupeHiragana().equals("N")) {
                                Hiragana_ArrayList_Groupe_0.add(hiragana);
                            }
                        }
                        Hiragana_beforeT.setHiragana_ArrayList_Groupe_A(Hiragana_ArrayList_Groupe_A);
                        Hiragana_beforeT.setHiragana_ArrayList_Groupe_K(Hiragana_ArrayList_Groupe_K);
                        Hiragana_beforeT.setHiragana_ArrayList_Groupe_S(Hiragana_ArrayList_Groupe_S);
                        Hiragana_beforeT.setHiragana_ArrayList_Groupe_T(Hiragana_ArrayList_Groupe_T);
                        Hiragana_beforeT.setHiragana_ArrayList_Groupe_N(Hiragana_ArrayList_Groupe_N);
                        Hiragana_beforeT.setHiragana_ArrayList_Groupe_H(Hiragana_ArrayList_Groupe_H);
                        Hiragana_beforeT.setHiragana_ArrayList_Groupe_M(Hiragana_ArrayList_Groupe_M);
                        Hiragana_beforeT.setHiragana_ArrayList_Groupe_R(Hiragana_ArrayList_Groupe_R);
                        Hiragana_beforeT.setHiragana_ArrayList_Groupe_Y(Hiragana_ArrayList_Groupe_Y);
                        Hiragana_beforeT.setHiragana_ArrayList_Groupe_W(Hiragana_ArrayList_Groupe_W);
                        Hiragana_beforeT.setHiragana_ArrayList_Groupe_0(Hiragana_ArrayList_Groupe_0);
                        Hiragana_Learn.setHiragana_ArrayList_Groupe_A(Hiragana_ArrayList_Groupe_A);
                        Hiragana_Learn.setHiragana_ArrayList_Groupe_K(Hiragana_ArrayList_Groupe_K);
                        Hiragana_Learn.setHiragana_ArrayList_Groupe_S(Hiragana_ArrayList_Groupe_S);
                        Hiragana_Learn.setHiragana_ArrayList_Groupe_T(Hiragana_ArrayList_Groupe_T);
                        Hiragana_Learn.setHiragana_ArrayList_Groupe_N(Hiragana_ArrayList_Groupe_N);
                        Hiragana_Learn.setHiragana_ArrayList_Groupe_H(Hiragana_ArrayList_Groupe_H);
                        Hiragana_Learn.setHiragana_ArrayList_Groupe_M(Hiragana_ArrayList_Groupe_M);
                        Hiragana_Learn.setHiragana_ArrayList_Groupe_R(Hiragana_ArrayList_Groupe_R);
                        Hiragana_Learn.setHiragana_ArrayList_Groupe_Y(Hiragana_ArrayList_Groupe_Y);
                        Hiragana_Learn.setHiragana_ArrayList_Groupe_W(Hiragana_ArrayList_Groupe_W);
                        Hiragana_Learn.setHiragana_ArrayList_Groupe_0(Hiragana_ArrayList_Groupe_0);
                    } catch (JSONException e) {
                        Log.d("erreur", "******************" + message[1]);
                    }
                }
            }
        }
    }
//amine

    public void envoi(String operation, JSONArray lesDonneesJSON) {
        HTTPAccess accesDonnees = new HTTPAccess();
        accesDonnees.delegate = this;
        accesDonnees.addParam("operation", operation);
        accesDonnees.addParam("lesdonnees", lesDonneesJSON.toString());
        accesDonnees.execute(SERVERADDR);
    }
}