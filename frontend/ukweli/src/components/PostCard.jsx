import Image from "next/image";

const PostCard = ({article}) => {
    return (<article key={article.id} className="bg-white rounded-lg shadow p-6">
        <div className="flex items-center space-x-3 mb-4">
            <Image
                src={article.author.avatar || "/placeholder.svg"}
                alt={`${article.author.name}'s avatar`}
                width={40}
                height={40}
                className="rounded-full"
            />
            <div>
                <p className="font-semibold">{article.author.name}</p>
                <p className="text-sm text-gray-500">{article.date}</p>
            </div>
        </div>
        <h2 className="text-xl font-bold mb-2">{article.title}</h2>
        <p className="text-gray-600 mb-4">{article.excerpt}</p>
        <div className="text-right">
            <a href="#" className="text-blue-500 hover:underline">
                Read more
            </a>
        </div>
    </article>);
};

export default PostCard;