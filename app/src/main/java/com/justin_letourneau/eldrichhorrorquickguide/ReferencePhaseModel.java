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
            public Integer image;
            public String description;

            public ArrayList<String> detail;

            public ReferenceAction(String title, Integer image, String description, ArrayList<String> detail) {
                this.title = title;
                this.image = image;
                this.description = description;
                this.detail = detail;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.title);
                dest.writeValue(this.image);
                dest.writeString(this.description);
                dest.writeStringList(this.detail);
            }

            protected ReferenceAction(Parcel in) {
                this.title = in.readString();
                this.image = (Integer) in.readValue(Integer.class.getClassLoader());
                this.description = in.readString();
                this.detail = in.createStringArrayList();
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
