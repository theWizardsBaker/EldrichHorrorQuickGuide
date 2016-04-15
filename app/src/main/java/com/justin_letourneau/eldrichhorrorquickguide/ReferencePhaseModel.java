package com.justin_letourneau.eldrichhorrorquickguide;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Neil on 4/10/2016.
 */
public class ReferencePhaseModel implements Parcelable{
    public ArrayList<ReferencePhase> phase;

    public ReferencePhaseModel(ArrayList<ReferencePhase> phase) {
        this.phase = phase;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(phase);
    }

    protected ReferencePhaseModel(Parcel in) {
        this.phase = in.createTypedArrayList(ReferencePhase.CREATOR);
    }

    public static final Creator<ReferencePhaseModel> CREATOR = new Creator<ReferencePhaseModel>() {
        @Override
        public ReferencePhaseModel createFromParcel(Parcel source) {
            return new ReferencePhaseModel(source);
        }

        @Override
        public ReferencePhaseModel[] newArray(int size) {
            return new ReferencePhaseModel[size];
        }
    };

    public static class ReferencePhase implements Parcelable{
        public String title;
        public String subtitle;
        public ArrayList<ReferenceAction> actions;

        public ReferencePhase(String title, String subtitle, ArrayList<ReferenceAction> actions) {
            this.title = title;
            this.subtitle = subtitle;
            this.actions = actions;
        }

        public static class ReferenceAction implements Parcelable{
            public String title;
            public String image;
            public String description;
            public ArrayList<ChildAction> detail;

            public ReferenceAction(String title, String image, String description, ArrayList<ChildAction> detail) {
                this.title = title;
                this.image = image;
                this.description = description;
                this.detail = detail;
            }

            public static class ChildAction implements Parcelable {
                public String image;
                public String description;

                public ChildAction(String image, String description) {
                    this.image = image;
                    this.description = description;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(this.image);
                    dest.writeString(this.description);
                }

                protected ChildAction(Parcel in) {
                    this.image = in.readString();
                    this.description = in.readString();
                }

                public static final Creator<ChildAction> CREATOR = new Creator<ChildAction>() {
                    @Override
                    public ChildAction createFromParcel(Parcel source) {
                        return new ChildAction(source);
                    }

                    @Override
                    public ChildAction[] newArray(int size) {
                        return new ChildAction[size];
                    }
                };
            }


            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.title);
                dest.writeString(this.image);
                dest.writeString(this.description);
                dest.writeTypedList(detail);
            }

            public ReferenceAction() {
            }

            protected ReferenceAction(Parcel in) {
                this.title = in.readString();
                this.image = in.readString();
                this.description = in.readString();
                this.detail = in.createTypedArrayList(ChildAction.CREATOR);
            }

            public static final Creator<ReferenceAction> CREATOR = new Creator<ReferenceAction>() {
                @Override
                public ReferenceAction createFromParcel(Parcel source) {
                    return new ReferenceAction(source);
                }

                @Override
                public ReferenceAction[] newArray(int size) {
                    return new ReferenceAction[size];
                }
            };
        }


        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.title);
            dest.writeString(this.subtitle);
            dest.writeTypedList(actions);
        }

        protected ReferencePhase(Parcel in) {
            this.title = in.readString();
            this.subtitle = in.readString();
            this.actions = in.createTypedArrayList(ReferenceAction.CREATOR);
        }

        public static final Creator<ReferencePhase> CREATOR = new Creator<ReferencePhase>() {
            @Override
            public ReferencePhase createFromParcel(Parcel source) {
                return new ReferencePhase(source);
            }

            @Override
            public ReferencePhase[] newArray(int size) {
                return new ReferencePhase[size];
            }
        };
    }


}
