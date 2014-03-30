cp deps/frameworks/ex/chips/res/drawable/list_item_font_primary.xml res/drawable/
cp deps/frameworks/ex/chips/res/drawable/list_item_font_secondary.xml res/drawable/

DEST_DIR=src/android/database/sqlite/
mkdir -p src/android/database/sqlite/
cp deps/frameworks/base/core/java/android/database/sqlite/SqliteWrapper.java $DEST_DIR

DEST_DIR=src/com/android/internal/telephony/
mkdir -p $DEST_DIR
cp deps/frameworks/base/telephony/java/com/android/internal/telephony/PhoneConstants.java $DEST_DIR
cp deps/frameworks/base/telephony/java/com/android/internal/telephony/RILConstants.java $DEST_DIR
cp deps/frameworks/base/telephony/java/com/android/internal/telephony/TelephonyIntents.java $DEST_DIR

DEST_DIR=src/android/telephony/
mkdir -p $DEST_DIR
cp deps/frameworks/base/telephony/java/android/telephony/PhoneNumberFormattingTextWatcher.java $DEST_DIR
cp deps/frameworks/base/telephony/java/android/telephony/PhoneNumberUtils.java $DEST_DIR

DEST_DIR=src/android/net/
mkdir -p $DEST_DIR
cp deps/frameworks/base/core/java/android/net/NetworkUtils.java $DEST_DIR

DEST_DIR=src/android/provider/
cp deps/frameworks/base/core/java/android/provider/Downloads.java $DEST_DIR

DEST_DIR=
